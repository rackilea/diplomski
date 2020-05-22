public static Object getFromSession
        (Serializable identifier, Class<?> clazz, Session s) {              
    String entityName = clazz.getName();
    if(identifier == null) {
       return null;
    }      
    SessionImplementor sessionImpl = (SessionImplementor) s;
    EntityPersister entityPersister = sessionImpl.getFactory().getEntityPersister(entityName);
    PersistenceContext persistenceContext = sessionImpl.getPersistenceContext();
    EntityKey entityKey = new EntityKey(identifier, entityPersister, EntityMode.POJO);
    Object entity = persistenceContext.getEntity(entityKey);
    return entity;
    }