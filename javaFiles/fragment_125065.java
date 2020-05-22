public EntityManager getEntityManager(){
    if( emf == null ){
        if (parameters == null) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        } else {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName, parameters);
        }
    } else {
        emf.getCache().evictAll();
    }

    EntityManager em = emf.createEntityManager();
    return em;
}