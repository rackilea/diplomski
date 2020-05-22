@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DemoApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory
            .getLogger(DemoApplication.class);

    @Autowired
    private AppProperties appProperties;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info("pattern = {}", appProperties.getPasswordPatterns().get("pattern1"));
    }
}