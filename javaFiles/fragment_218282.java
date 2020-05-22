public enum Schema {
    A, B
}

public EntityDaoImpl {

    // Create and populate the map at DAO creation time (Spring etc.).
    private Map<Schema, SessionFactory> sessionFactoryBySchema = ...; 

    private Session getSession(Schema schema) {
        SessionFactory sessionFactory = sessionFactoryBySchema.get(schema);
        return sessionFactory.getCurrentSession(); // ... or whatever
    }

    public void saveEntity(Schema schema, Entity entity) {
        getSession(schema).save(entity);
    }
}