import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Run like any other JUnit Test. Only one required dependency
 *
 * <dependency>
 *   <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *   <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
 *   <version>${jersey2.version}</version>
 * </dependency>
 *
 * @author Paul Samsotha
 */
public class ConfigExample extends JerseyTest {

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Config {
        String value();
    }

    public static class ConfigInjectionResolver implements InjectionResolver<Config> {

        private static final Map<String, String> properties = new HashMap<>();

        public ConfigInjectionResolver() {
            properties.put("greeting.message", "Hello World");
        }

        @Override
        public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
            if (String.class == injectee.getRequiredType()) {
                AnnotatedElement elem = injectee.getParent();
                if (elem instanceof Constructor) {
                    Constructor ctor = (Constructor) elem;
                    Config config = (Config) ctor.getParameterAnnotations()[injectee.getPosition()][0];
                    return properties.get(config.value());
                } else {
                    Config config = elem.getAnnotation(Config.class);
                    return properties.get(config.value());
                }
            }
            return null;
        }

        @Override
        public boolean isConstructorParameterIndicator() { return true; }

        @Override
        public boolean isMethodParameterIndicator() { return false; }
    }


    private static interface GreetingService {
        String getGreeting();
    }

    private static class ConfiguredGreetingService implements GreetingService {
        private String message;

        public ConfiguredGreetingService(@Config("greeting.message") String message) {
            this.message = message;
        }

        @Override
        public String getGreeting() {
            return this.message;
        }
    }

    @Path("greeting")
    public static class GreetingResource {

        @Inject
        private GreetingService greetingService;

        @GET
        public String getConfigProp() {
            return greetingService.getGreeting();
        }
    }

    @Override
    public ResourceConfig configure() {
        ResourceConfig config = new ResourceConfig(GreetingResource.class);
        config.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        config.register(new AbstractBinder(){
            @Override
            protected void configure() {
                bind(ConfiguredGreetingService.class).to(GreetingService.class).in(Singleton.class);
                bind(ConfigInjectionResolver.class)
                        .to(new TypeLiteral<InjectionResolver<Config>>(){})
                        .in(Singleton.class);
            }
        });
        return config;
    }

    @Test
    public void should_get_configured_greeting() {
        final Response response = target("greeting")
                .request().get();
        assertEquals("Hello World", response.readEntity(String.class));
    }
}