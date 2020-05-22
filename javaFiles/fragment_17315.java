public class SessionFactoryFactory implements Factory<SessionFactory> {

    private final SessionFactory factory;

    public SessionFactoryFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
        srBuilder.applySettings(configuration.getProperties());
        factory = configuration.buildSessionFactory(srBuilder.build());
        System.out.println("--- SessionFactory Created ---");
    }

    @Override
    public SessionFactory provide() {
        System.out.println("--- SessionFactory Provided ---");
        return factory;
    }

    @Override
    public void dispose(SessionFactory factory) {
        factory.close();
    }
}