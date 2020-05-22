@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplicationBuilder(Application.class).web(false).application();
        ConfigurableApplicationContext context = application.run(args);
        Service s = context.getBean(Service.class);
        s.accessErrorCode();
    }
}