@Configuration
@ComponentScan //Make sure MockConfig is below all beans to discover
public class MockConfig {
    @Bean
    @Real
    public WeatherStationService weatherServiceReal() {
        return  new WeatherStationService();
    }
}