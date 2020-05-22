@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    public ApplicationContextProvider applicationContextProvider() {
        return new ApplicationContextProvider();
    }

    ...
}