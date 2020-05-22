@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class)

    public static void main(String... args) {
        SpringApplication.run(Application.class, args); 
    }

    @Bean
    public MyCommandLineRunner schedulerRunner(DataSource ds) {
        return (args) -> (logger.info("DataSource: {}", ds); 
    }
}