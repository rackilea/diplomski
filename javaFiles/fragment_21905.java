@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        packages("packages.to.scan");
        register(RolesAllowedDynamicFeature.class);
    }
}