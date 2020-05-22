@SpringBootApplication
@EnableSwagger2
public class SpringBootAppMain implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
    @Autowired
    Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppMain.class, args);
    }

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent embeddedServletContainerInitializedEvent) {
        System.out.println("Port " + embeddedServletContainerInitializedEvent.getApplicationContext().getEmbeddedServletContainer().getPort());
        try {
            System.out.println("HOST Address " + InetAddress.getLocalHost().getHostAddress());
            System.out.println("Host Name " + InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {

        }
    }
}