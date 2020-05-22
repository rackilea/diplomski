@SpringBootApplication
public class AccessingDataJpaApplication implements CommandLineRunner {

    @Autowired
    private OffersRepository repository;

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Override
    public void run(String...args) {
        log.info("Offers found with findByStatus('0'):");
        log.info("--------------------------------------------");
        repository.findByStatus("0").forEach(on - >{
            log.info(on.toString());
        });
        log.info("");
    }

}