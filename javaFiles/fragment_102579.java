@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final Log logger = LogFactory.getLog(getClass());
    private final DataSource ds;

    public MyCommandLineRunner(DataSource ds) { this.ds = ds; }

    @Override
    public void run(String... args) throws Exception {
        logger.info("DataSource: " + ds.toString());
    }
}