@Configuration
public class Config {

    @Autowired Properties externalConfigProperties;

    @Bean
    PropertyPlaceholderConfigurer configurer(){
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setSystemPropertiesModeName("SYSTEM_PROPERTIES_MODE_OVERRIDE");
        configurer.setOrder(10);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setProperties(externalConfigProperties);
        return configurer;
    }

}