public class PersistenceUtil {

        private static EntityManagerFactory entityManagerFactory;

        static {
            entityManagerFactory = Persistence.createEntityManagerFactory("testdb");
        }

        public static EntityManager getEntityManager() {
            final EntityManager entityManager = entityManagerFactory.createEntityManager();
            return entityManager;
        }

    public static void closeEntityManagerFactory() {
           entityManagerFactory.close();
        }
    }




public class TestClass {
    public static void main(String[] args) {
        final EntityManager em = PersistenceUtil.getEntityManager();
        final EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        final TestTable testTable = new TestTable();
        testTable.setData("Sample Data");
        em.merge(testTable);
        transaction.commit();
        em.close():
        PersistenceUtil.closeEntityManagerFactory()

    }
}