@Specializes
public class TestEntityManagerProducer extends EntityManagerProducer {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("...");

    @Produces
    //...
    @Override
    protected EntityManager create() {
        return emf.createEntityManager();
    }

    @Override
    protected void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}