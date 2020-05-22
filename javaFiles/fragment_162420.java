@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExampleApplication.class, args);
        RemoteTokenServices remoteTokenServices = context.getBean(RemoteTokenServices.class);
        remoteTokenServices.setTokenName("otoken");
    }
}