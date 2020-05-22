EntityPersister persister = ((SessionFactoryImpl) session.getSessionFactory()).getEntityPersister("theNameOfYourEntity");

if (persister.hasCache() && 
    !persister.isCacheInvalidationRequired() && 
    session.getCacheMode().isPutEnabled()) {

    CacheKey ck = new CacheKey( 
                    theEntityToBeCached.getId(), 
                    persister.getIdentifierType(), 
                    persister.getRootEntityName(), 
                    session.getEntityMode(), 
                    session.getFactory() 
                );

    persister.getCacheAccessStrategy().afterInsert(ck, theEntityToBeCached, null);
}