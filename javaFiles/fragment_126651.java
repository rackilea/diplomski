import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class Application {

    @Bean
    @Lazy
    public Foo foo() {
        return new Foo();
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        ctx.getBeanFactory().getBeanNamesIterator().forEachRemaining(bean -> {
            try {
                final BeanDefinition beanDefinition = ctx.getBeanFactory().getBeanDefinition(bean);
                if (beanDefinition.isLazyInit()) {
                    System.out.println("Bean '" + bean + "' is lazy initialized...");
                }
            } catch (NoSuchBeanDefinitionException e) {}
        });
    }

    static class Foo {
        private boolean bar = true;
    }
}