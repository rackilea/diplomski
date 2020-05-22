@Configuration
public class ApplicationConfig {
    @Bean
    public A a() {
        return new A(new CustomMap<> (MySupplier::new));
    }
}