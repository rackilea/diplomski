@Service
public class MongoService {

    private final Mongo mongo;
    private final String database;
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoService.class);

@bean
    public MongoService(@Nonnull final @Value("#{ systemProperties['host']}") String host, @Nonnull final @Value("#{ systemProperties['port']}") int port, @Nonnull final @Value("#{ systemProperties['database']}") String db) throws UnknownHostException {
        LOGGER.info("host=" + host + ", port=" + port + ", database=" + db);
        mongo = new Mongo(host, port);
        database = db;
    }
}