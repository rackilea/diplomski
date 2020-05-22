@SpringBootApplication
@PropertySource("classpath:global.properties")
@EnableConfigurationProperties({GlobalProperties.class})
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        GlobalProperties globalProperties = context.getBean(GlobalProperties.class);
        System.out.println(globalProperties);
    }
}