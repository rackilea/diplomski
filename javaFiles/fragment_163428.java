@ApplicationScoped
public class MongoProducer {

    @Inject
    private MongoClient mongoClient;

    @Inject
    private BeanManager bm;

    @Produces
    @Mongo
    protected MongoCollection produceCollection(InjectionPoint ip) {
        String dbName = bm.getExtension(MongoClientExtension.class).getDatabaseName();
        Mongo mongo = getMongoAnnotation(ip);
        return mongoClient.getDatabase(dbName).getCollection(collectionName,mongo.collection());
    }

    private Mongo getMongoAnnotation(InjectionPoint ip) {
        return ip.getAnnotated().getAnnotation(Mongo.class);
    }
}