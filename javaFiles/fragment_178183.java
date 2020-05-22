public abstract class JpaDao implements Dao {
    protected Class entityClass;

    @PersistenceContext
    protected EntityManager entityManager;
    //so on.. and delegate calls to entity manager.