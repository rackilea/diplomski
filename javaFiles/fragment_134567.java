public class EntityController {

    private static EntityManagerFactory entityManagerFactory = null;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("research");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static void startTransaction(EntityManager entityManager){
        entityManager.getTransaction().begin();
    }


    public static void finishTransaction(EntityManager entityManager){
        if (entityManager.isOpen()){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            if (entityTransaction.isActive()) {
                entityManager.getTransaction().commit();
            }
            entityManager.close();
        }
    }
}