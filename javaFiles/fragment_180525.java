Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = null;
try {
   tx = session.beginTransaction();
   // work with the db
   tx.commit();
}
catch (Exception e) {
  if (tx != null) {
    tx.rollback();
  }
  // Handle the exception, print message, etc.
} finally {
   session.close();
}