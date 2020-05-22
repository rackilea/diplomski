Transaction transaction = null;
Session session = null;
try {
    //create the session object with openSession() and then begin transaction on session         
    session = sessionFactory().openSession();
    transaction = session.beginTransaction();
    session.update(auditorium);
    transaction.commit();

} catch(HibernateException e) {
    transaction.rollback();
} finally {
    session.close();
}