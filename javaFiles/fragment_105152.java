@Configuration
public class Config {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propConfigurer = new PropertySourcesPlaceholderConfigurer();
        propConfigurer.setLocation(new ClassPathResource("application.properties"));
        return propConfigurer;
    }

    @Bean
    @Scope("prototype")
    public UserDomain userDomain() {
        return new UserDomain();
    }

    ...
}