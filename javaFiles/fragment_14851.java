public DBReaderImpl(DataSource source)
{
    this.source = source;


    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

    hibernateProperties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    hibernateProperties.setProperty("hibernate.connection.url", "jdbc:mysql://" + source.getHost() + "/" + source.getDataBase());
    hibernateProperties.setProperty("hibernate.connection.username", source.getUsername());
    hibernateProperties.setProperty("hibernate.connection.password", source.getPassword());
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate");

    Configuration configuration = new Configuration();
    configuration.setProperties(hibernateProperties);
    configuration.addAnnotatedClass(Route.class);

    SessionFactory sessionFactory = configuration.configure().buildSessionFactory(
            new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    List<Route> routes = session.createQuery("SELECT r FROM Route r").list();

    for (Route route : routes)
    {
        System.out.println(route);
    }

    session.close();
}