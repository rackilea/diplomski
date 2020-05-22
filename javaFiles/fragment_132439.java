SessionImplementor sessionImplementor = ((SessionImplementor)session);
        EntityPersister entityPersister = sessionImplementor.getFactory().getEntityPersister( clazz.getName() );
        PersistenceContext persistenceContext = sessionImplementor.getPersistenceContext();

        EntityKey entityKey = new EntityKey( id, entityPersister, EntityMode.POJO );

        Object entity = persistenceContext.getEntity( entityKey );

        if ( entity != null )
            return entity;

        entity = persistenceContext.getProxy( entityKey );

        if ( entity != null )
            return entity;

        return null;