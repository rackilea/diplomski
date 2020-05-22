@SpringBootApplication
@EnableConfigurationProperties(ConfigBinder.class)
public class Application {

    public static void main(String[] args) {
        final ApplicationContext ctx = SpringApplication.run(Application.class, args);
        final ConfigBinder confs = ctx.getBean(ConfigBinder.class);
        System.out.println(confs.getUrl());
        System.out.println(confs.getName());
    }

}