public static SessionFactory getSessionFactory() {

    if(sessionFactory == null){
        sessionFactory = buildSessionFactory();
    }
    return sessionFactory;
}