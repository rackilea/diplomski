@Configuration
public class MyApplicationConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        String activeProfile = System.getProperty("spring.profiles.active", "production"); 
        String ymlFilename = "cloud-config-" + activeProfile + ".yml";

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource(ymlFilename));

        return configurer;
    }
}