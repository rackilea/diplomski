public class CouchDbRepositorySupport<C, T extends CouchDbRepositorySupport<C>> implements GenericRepository<T> {
...

    protected CouchDbRepositorySupport(Class<C> type, CouchDbConnector db) {
        ...
    }

public class OrderRepository extends CouchDbRepositorySupport<MenuItem, Order<MenuItem>> {

    public OrderRepository(CouchDbConnector db) {
        super(MenuItem.class, db);