public class FooDaoImpl implements FooDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(Foo foo) {
        entityManager.persist(foo);
    }
}