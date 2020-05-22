@Configuration
@PropertySource("/app.properties")
public class Test {
    @Value("${prop1}")
    String prop1;

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}