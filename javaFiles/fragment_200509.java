@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    @Autowired
    private OffersRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {

            // fetch by status =0
            log.info("Offers found with findByStatus('0'):");
            log.info("--------------------------------------------");
            repository.findByStatus("0").forEach(on -> {
                log.info(on.toString());
            });
            log.info("");
        };
    }

}