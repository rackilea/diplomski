public class EntityManagerFactoryProducer {

    @Produces
    @ApplicationScoped
    @MyFirstDatabase
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PRIMARY_PU");
        return emf;
    }

    @Produces
    @ApplicationScoped
    @MySecondDatabase
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SECONDARY_PU");
        return emf;
    }

    public void close(@Disposes EntityManagerFactory entityManagerFactory) {
        entityManagerFactory.close();
    }

    @Produces
    @Dependent
    @MyFirstDatabase
    public EntityManager createEntityManager(@MyFirstDatabase EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Produces
    @Dependent
    @MySecondDatabase
    public EntityManager createEntityManager(@MySecondDatabase EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager entityManager) {
        entityManager.close();
    }
}