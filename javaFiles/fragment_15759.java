@Configuration
@PropertySource(value = "classpath:application.properties")
public class AppConfig{

@Bean
public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}