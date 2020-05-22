@Configuration
@PropertySource("classpath:someFile.properties")
public class SampleConfig { 

    // other configs...

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}