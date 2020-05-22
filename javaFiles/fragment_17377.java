public class MongoDbConfig {
    @Bean(name = {"sourceTemplate", "mongoTemplate"})
    public MongoTemplate getSourceTemplate() {
        MongoTemplate mt = new MongoTemplate(getMongoDbFactory(sourceServers, sourceDatabaseName));
        return mt;
    }

    @Bean(name="destinationTemplate")
    public MongoTemplate getDestinationTemplate() {
        MongoTemplate mt = new MongoTemplate(getMongoDbFactory(destinationServers, destinationDatabaseName));
        return mt;
    }
}

public class SourceDaoImpl implements SourceDao {
    @Autowired
    @Qualifier("sourceTemplate")
    private MongoOperations mongoOps;
}


public class DestinationDaoImpl implements DestinationDao {
    @Autowired
    @Qualifier("destinationTemplate")
    private MongoOperations mongoOps;
}