public Session newSession(){
    Session session = sessionFactory.openSession();
    // this assumes you don't have criteria to set depending on the context
    session.enableFilter("yourFilter");  
    return session;
}