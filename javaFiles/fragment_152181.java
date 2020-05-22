@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("the.packages.to.scan");
        register(SwaggerComponent.class);
    }
}