Session session = HibernateUtil.getCurrentSession();

try {
    session.beginTransaction();    
    // execute some code that violates a unique constraint
    ...
    session.getTransaction().commit();  
} catch (HibernateException e) {
    session.getTransaction().rollback();
}

// keep using the session
try {
    session.beginTransaction();    
    ...
    session.getTransaction().commit();  
} catch (HibernateException e) {
    session.getTransaction().rollback();
}
// do we reach this point?