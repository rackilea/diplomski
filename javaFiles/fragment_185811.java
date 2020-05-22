@Configuration
public class AppConfig {
    @Bean AppServiceImpl appServiceImpl(@Value("${value.one}") String value1,  @Value("${value.two}") String value2,  @Value("${value.three}") String value3) {
        return new AppServiceImpl(value1, value2, value3);
    }
}