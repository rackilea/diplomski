public int vratiBroj() {
    Session currentSession = sessionFactory.getCurrentSession();
    Query query = currentSession.createQuery("SELECT count(*) from Komitent"); 
    long num = (Long) query.getSingleResult();
    return num.intValue();
}