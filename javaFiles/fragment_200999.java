public class TransactionTemplate {

    public <T> T execute(Callable<T> doInTransaction) throws Exception {
        EntityManager em = EntityManagerFactory.get();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            T result = doInTransaction.call();
            transaction.commit();
            return result;
        } catch(/* Some exception that causes a rollback */ e) {
           transaction.rollback();
           throw e;
        } finally {
           em.close();
        }
    }
}