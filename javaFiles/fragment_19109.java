public SessionFactory buildSessionFactory() throws HibernateException {
    log.debug( "Preparing to build session factory with filters : " + filterDefinitions );
    secondPassCompile();
    validate();
    Environment.verifyProperties( properties );
    Properties copy = new Properties();
    copy.putAll( properties );
    PropertiesHelper.resolvePlaceHolders( copy );
    Settings settings = buildSettings( copy );

    return new SessionFactoryImpl(
            this,
            mapping,
            settings,
            getInitializedEventListeners(),
            sessionFactoryObserver
        );
}