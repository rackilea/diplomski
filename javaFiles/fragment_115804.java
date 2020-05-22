EntityManagerFactory entityManagerFactory = fBean.getObject();

    JpaTransactionManager txMgr = new JpaTransactionManager();
    txMgr.setEntityManagerFactory(entityManagerFactory);
    txMgr.afterPropertiesSet();

    jpa.setEntityManagerFactory(entityManagerFactory);
    jpa.setTransactionManager(txMgr);