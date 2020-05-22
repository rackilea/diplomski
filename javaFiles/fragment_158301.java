Set<javax.persistence.metamodel.EntityType<?>> entityTypes = entityManagerFactory.getMetamodel().getEntities();
    for (javax.persistence.metamodel.EntityType entityType : entityTypes){
        logger.info(entityType.getName());
        logger.info(entityType.getJavaType().getCanonicalName());
        logger.info("******************************");
    }