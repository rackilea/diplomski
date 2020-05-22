if (TransactionSynchronizationManager.hasResource(getEntityManagerFactory())) {
        ...
    }
    else {
        logger.debug("Opening JPA EntityManager in OpenEntityManagerInViewInterceptor");
        try {
            EntityManager em = createEntityManager();
            EntityManagerHolder emHolder = new EntityManagerHolder(em);
            TransactionSynchronizationManager.bindResource(getEntityManagerFactory(), emHolder);

            ...
        }
        catch (PersistenceException ex) {
            throw new DataAccessResourceFailureException("Could not create JPA EntityManager", ex);
        }
    }