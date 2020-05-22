@EnableMongoRepositories(repositoryBaseClass = MyMongoRepository.class)
static class Config {
}

static class MyMongoRepository<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> {

    private final MongoEntityInformation<T, ID> metadata;
    private final MongoOperations mongoOperations;

    public MyMongoRepository(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.metadata = metadata;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<T> findAll() {

        Query query = new Query();
        query.restrict(this.metadata.getJavaType());

        return this.mongoOperations.find(query, this.metadata.getJavaType(), this.metadata.getCollectionName());
    }
}