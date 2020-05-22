final Session session = getSession();
try {
    session.beginTransaction();
    session.save(vendorRegistration);
    session.getTransaction().commit();                           
} catch (Exception e) {
    session.getTransaction().rollback();
}  finally {       
    session.close();
}