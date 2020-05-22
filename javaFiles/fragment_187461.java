package singleton;

import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class AppMain {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext();
        rootContext.register(AppRootContext.class);
        rootContext.refresh();

        final AnnotationConfigApplicationContext servletContext = new AnnotationConfigApplicationContext();
        servletContext.register(AppServletContext.class);
        servletContext.refresh();

        final Singleton one = (Singleton) rootContext.getBean("singleton");
        final Singleton andAnotherOne = (Singleton) servletContext.getBean("singleton");

        System.out.println("Singletons are " + (one.ID.equals(andAnotherOne.ID) ? "equal" : "different"));
    }
}

@Component
class Singleton {public String ID = UUID.randomUUID().toString();}

@Configuration
@ComponentScan(basePackages = { "singleton" })
class AppRootContext {}

@Configuration
@ComponentScan(basePackages = { "singleton" })
class AppServletContext {}