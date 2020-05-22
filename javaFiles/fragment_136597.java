public class ApplicationConfig {

    @Bean
    @Profile("production")
    public FooInterface productionVendorCore() {
        return new ProductionImpl();
    }

    @Bean
    @Profile("dev")
    public FooInterface devVendorCore() {
        return new DevImpl();
    }
    //....
}