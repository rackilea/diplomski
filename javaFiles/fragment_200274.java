public class EntityManagerProducer {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces 
    public EntityManager create() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}