@Slf4j
@EnableIntegration
@EnableLoaderApplication
@SpringBootApplication
@EnableDiscoveryClient
public class MyExampleApplication implements CommandLineRunner {

    private static final String SYSTEM_NAME_INFO = "My Example Application";
    private static final String VERSION="0.0.1";

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(MyExampleApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception{
        BuildProperties buildProperties = context.getBean(BuildProperties.class);
        displayInfo(buildProperties);
    }

    private static void displayInfo(BuildProperties buildProperties) {
        log.info("build version is <" + buildProperties.getVersion() + ">");
    log.info("value for custom key 'foo' is <" + buildProperties.get("foo") + ">");
    }

}