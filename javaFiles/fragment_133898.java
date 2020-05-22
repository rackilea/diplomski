public class HibernateAction2{ // no longer abstract

    private EntityManagerFactory entityManagerFactory;

    public HibernateAction2(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    //we expect a user to pass lambda function, which would tell us what to do with an entity manager
    public boolean perform (Consumer<EntityManager> action) throws Exception {
        try {
            var entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            action.accept(entityManager);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}