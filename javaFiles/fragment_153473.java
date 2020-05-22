@Qualifier
@Retention(RUNTIME)
@Target(METHOD, FIELD, PARAMETER, TYPE)
public interface @MyEm {
}

public class EntityProducer {
    @PersistenceContext(unitName = 'MyPU', type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Produces
    @MyEm
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

public class MyDAO {
    @Inject
    @MyEm
    private EntityManager entityManager;
}