@ApplicationPath("/service")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("com.servicetest.person.resources");
        register(LoggingFilter.class);
    }
}