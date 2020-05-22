@ApplicationPath("/")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("scan.packages.for.resource.and.provider");
        register(ResourceOrProvider.class);
        register(new MyAppBinder());
    }
}