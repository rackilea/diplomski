public class CustomMongoRepositoryImpl<T extends BaseEntity>
        extends SimpleMongoRepository<T, Long> implements CustomMongoRepository<T> {

    CustomMongoRepositoryImpl(
        MongoEntityInformation<T, Long> entityInformation,
        MongoOperations mongoOperations) {

        super(entityInformation, mongoOperations);
    }

    @Override
    public <S extends T> S insert(S entity) {
        generateId(entity);
        return super.insert(entity);
    }

    @Override
    public <S extends T> List<S> insert(Iterable<S> entities) { ... }

    @Override
    public <S extends T> S save(S entity) { ... }

    @Override
    public <S extends T> List<S> save(Iterable<S> entities) { ... }

    protected <S extends T> void generateId(S entity) { ... }

}