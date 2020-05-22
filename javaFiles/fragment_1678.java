public static <T> T loadObject(Class<T> clazz, Serializable key) {
    Session session = sessionFactory.getCurrentSession();
    T dbObject;

    try {
        session.beginTransaction();
        dbObject = clazz.cast(session.get(clazz, key));
    } 
    finally {
        session.getTransaction().commit();
    }

    return dbObject;
}