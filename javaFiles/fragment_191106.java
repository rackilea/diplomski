@Singleton
public class MySingleton {


    private final Logger logger;

    @Inject
    public MySingleton (Logger logger) {
        this.logger = logger;
        logger.info("Creating one and only one instance here!");
    }
}