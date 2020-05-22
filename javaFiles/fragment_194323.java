@SpringBootApplication
@EnableConfigurationProperties(ServerProperties.class)
public class DemoApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    ServerProperties serverProperties;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("serverProperties.getContextPath(): " + serverProperties.getContextPath());
    }
}