@SpringBootApplication
public class Application {

    public static void main(String[] args) {       
        YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
        yamlFactory.setResources(new ClassPathResource("application.yml"));
        Properties props = yamlFactory.getObject();

        String hostname = props.getProperty("spring.rabbitmq.hostname");
        ...

        SpringApplication.run(Application.class, args);
    }
}