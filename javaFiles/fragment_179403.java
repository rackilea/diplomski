@Configuration
@PropertySource(
          value={"classpath:properties/${property:defaultValue}.properties"},
          ignoreResourceNotFound = true)
public class ConfigExample {

    @Value("${propertyNameFromFile:defaultValue}")
    String propertyToBeInjected;

    /**
     * Property placeholder configurer needed to process @Value annotations
     */
     @Bean
     public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
     }
}