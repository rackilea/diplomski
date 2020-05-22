public SessionFactory getSessionFactory(final DataSource dataSource) {
    final LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
    sessionBuilder.addProperties(properties);
    sessionBuilder.scanPackages("com.em.daas.entity");
    return sessionBuilder.buildSessionFactory();
}