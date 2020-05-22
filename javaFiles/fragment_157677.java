@ApplicationPath("/rest")
public class AppConfig extends PackagesConfig {
    public AppConfig() {
        super("the.packages.to.scan.for.resources.and.provders");
    }
}