@SpringBootApplication
@EnableJms
public class ServerMain implements CommandLineRunner {
    private static final Logger log = LogManager.getLogger(ServerMain.class);

    @Autowired
    private DBHandler db;

    @Autowired
    private ScheduledTasks tasks;

    public static void main(String[] args) {
        log.warn("from main");
        ConfigurableApplicationContext context = SpringApplication.run(ServerMain.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("starting run");
        db.initDBTables();
        tasks.start();
    }