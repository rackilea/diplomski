@Configuration
public class MockConfig {
    @Bean
    @Real
    public WeatherStationService weatherServiceReal() {
        return  new WeatherStationService();
    }

    @Bean
    public WeatherStationRepositoryMock weatherStationRepository() {
        return new WeatherStationRepositoryMock()
    }
}