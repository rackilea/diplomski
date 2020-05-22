@Configuration
public class TestConfig {

    @Bean
    public MyService monitoringService() {
        return new MyService();
    }
}