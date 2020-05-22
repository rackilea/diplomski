@Configuration
@PropertySource("classpath:dev/food.properties")
public class ConfigA {}

@Configuration
@PropertySource("classpath:dev/animals.properties")
public class ConfigB {}

@Configuration
@ComponentScan("your-packages-here")
public class RootConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}