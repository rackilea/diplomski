@Singleton
public class MySingleton {

    @Inject
    Logger logger;

    @PostConstruct
    public void init() {
        logger.info("Creating one and only one instance here!");
    }

}