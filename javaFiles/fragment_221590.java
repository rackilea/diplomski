@SpringBootApplication
 @EnableSwagger2
 @EnableConfigurationProperties({MarketConfig.class})
 public class MarketApplication implements CommandLineRunner {

    private final MarketService service;
    private final MarketConfig config;

    public MarketApplication(MarketService service, MarketConfig config) {
       this.service = service;
       this.config = config;
    }