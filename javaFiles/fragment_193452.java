@Profile("test")
@Configuration
public class TestConfiguration {
    @Bean
    @Primary
    public SomeWebserviceClient someWebserviceClient() {
        return mock(SomeWebserviceClient.class);
    }
}