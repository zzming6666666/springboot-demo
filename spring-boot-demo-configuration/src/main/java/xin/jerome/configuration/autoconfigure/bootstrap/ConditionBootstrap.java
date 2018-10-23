package xin.jerome.configuration.autoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import xin.jerome.configuration.autoconfigure.condition.ConditionalOnSystemProperty;

/**
 * 验证手动实现基于编程{@link Condition}方式的条件装配
 *
 * @author Jerome Zhu
 * @since 2018.10.23 17:40
 */
public class ConditionBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "user")
    public String hello() {
        return "hello jerome !";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloBean = context.getBean("hello", String.class);
        System.out.println("hello Bean: " + helloBean);

        context.close();
    }

}
