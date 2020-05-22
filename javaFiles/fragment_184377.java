public class HibernateUtil {
    public static void inTransaction(TransactionCallback tc) {
        Transaction transaction = HibernateUtil.getSessionFactory().getCurrentSession().getTransaction();
        if (!HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
            transaction.begin();
            try {
                tc.doInTransaction();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }
}