@Stateless
public class ExceptionPersister {

    @PersistenceContext
    private EntityManager entityManager;

    @Asynchronous
    public void persist(Exception exception) {
        // use entityManager to persist exception in your
        // specific way.
    }
}