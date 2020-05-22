public class PGExceptionTest {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "pgextest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // here I attempt to persist an object with an ID that is already in use
        entityManager.persist(new PGExceptionTestBean(1));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}