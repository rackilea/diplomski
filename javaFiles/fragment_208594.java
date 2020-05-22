public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {
        final BootstrapServiceRegistry bootstrapServiceRegistry = new BootstrapServiceRegistryBuilder().enableAutoClose()
                .applyIntegrator(MetadataExtractorIntegrator.INSTANCE).build();

        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder(bootstrapServiceRegistry).configure().build();
        return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public static Session getSession() {
        Session hibernateSession = getSessionFactory().getCurrentSession();
        return hibernateSession;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}