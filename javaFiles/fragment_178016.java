@Bean
    public PlatformTransactionManager transactionManager() { // TODO: Really need this?
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }