abstract public class HibernateAction<T> {
    private EntityManagerFactory entityManagerFactory;
    //I'm passing EntityManagerFactory, because it should be singleton and you shouldn't
    //probably create it from scratch everytime
    public HibernateAction(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    protected abstract T action(EntityManager entityManager, T entity);

    public boolean perform(T entity) throws Exception {
        try {
            var entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            action(entityManager, entity); //call to action which need to be overriden
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }   
    }
}