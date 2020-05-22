@Override
protected SessionFactory newSessionFactory() {
    Properties properties = new Properties();
    ...
    //data source settings
    properties.put("hibernate.connection.datasource", hikariDataSource);
    return new Configuration()
    .addProperties(properties)
    .addAnnotatedClass(SecurityId.class)
    .buildSessionFactory(
            new StandardServiceRegistryBuilder()
            .applySettings(properties)
    .build()
);