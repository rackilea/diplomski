@Configuration
public class ConfigClientBootstrapConfiguration {

    @Autowired
    private ConfigurableEnvironment environment;
    @Autowired
    private ConfigServerProperties server;

    @Bean
    public MultipleJGitEnvironmentRepository environmentRepository() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("spring.cloud.config.server.bootstrap", "true");
        properties.put("spring.cloud.config.server.git.uri", "<GitHub repo URI>");
        properties.put("spring.cloud.config.server.git.username", "username");
        properties.put("spring.cloud.config.server.git.password", "password");
        properties.put("spring.application.name", "config");
        properties.put("spring.profiles.active", "development");
        MapPropertySource customPropertySource = new MapPropertySource("applicationConfig: [classpath:/bootstrap.properties]", properties);
        environment.getPropertySources().replace("applicationConfig: [classpath:/bootstrap.properties]", customPropertySource);
        MultipleJGitEnvironmentRepository repository = new MultipleJGitEnvironmentRepository(this.environment);
        if (this.server.getDefaultLabel() != null) {
            repository.setDefaultLabel(this.server.getDefaultLabel());
        }
        return repository;
    }

}