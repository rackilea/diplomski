@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@ComponentScan({"com.vmware.skyscraper", "com.skyscraper.vdisizer"})
public class ServerApplication {

private static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

/**
 * Start the Spring Boot application.
 *
 * @param args command line arguments
 */
public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
    logger.info("Sample Application started with context {}", context.getDisplayName());
  }
}