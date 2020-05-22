@Configuration
public class SecurePropertiesConfig {

    @Autowired
    private ConfigurableEnvironment env;

    @Autowired
    public void setConfigurableEnvironment(ConfigurableEnvironment env) {
        try {
            final Resource resource = new ClassPathResource("secure.properties");
            env.getPropertySources().addFirst(new PropertiesPropertySource(resource.getFilename(), PropertiesLoaderUtils.loadProperties(resource)));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}