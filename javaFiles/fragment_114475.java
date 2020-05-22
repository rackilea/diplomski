// Custom repository interface
@NoRepositoryBean
public interface ExtendedMongoRepository<T, ID extends Serializable> extends MongoRepository<T, ID>, QueryDslPredicateExecutor<T>{

  public Page<T> query(Query query, Pageable pageable);

}


// Custom Repository Implementation
public abstract class ExtendedMongoRepositoryImpl<T, ID extends Serializable> extends QueryDslMongoRepository<T, ID>
        implements ExtendedMongoRepository<T, ID> {

    private Class<T> clazz;
    private MongoOperations mongoOperations;
    @SuppressWarnings("unused")
    private MongoEntityInformation<T, ID> metadata;

    public ExtendedMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoOperations = mongoOperations;
        this.clazz = metadata.getJavaType();
        this.metadata = metadata;
    }

    @Override
    public Page<T> query(Query query, Pageable pageable) {
        List<T> list =  mongoOperations.find(query.with(pageable), clazz);
        return new PageImpl<T>(list, pageable, list.size());
    }
}  

// Entity Repository Interface
public interface TreeRepository extends ExtendedMongoRepository<Tree, String> {}