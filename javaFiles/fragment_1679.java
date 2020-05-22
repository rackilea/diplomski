public static <T> T loadObject(Class<T> clazz, 
                               Serializable key, 
                               Initializer<T> initializer) {
    Session session = sessionFactory.getCurrentSession();
    T dbObject;

    try {
        session.beginTransaction();
        dbObject = clazz.cast(session.get(clazz, key));
        initializer.initialize(dbObject);
    } 
    finally {
        session.getTransaction().commit();
    }

    return dbObject;
}