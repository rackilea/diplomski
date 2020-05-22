public class DatabaseUtilities {
    private static final SessionFactory sessionFactory = null;

    private static SessionFactory buildSessionFactory(String configFile) {
        try {
            return new AnnotationConfiguration().configure(configFile).buildSessionFactory();           
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }   

    public static synchronized SessionFactory getSessionFactory(String configFile) {
            if (sessionFactory == null) {
                sessionFactory = buildSessionFactory(configFile);   
            }
            return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    private DatabaseUtilities() {}
}