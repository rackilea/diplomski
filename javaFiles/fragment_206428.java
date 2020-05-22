public class HibernateUtil {    

    private static final SessionFactory SESSIONFACTORY = buildSessionFactory();
    private static final String HIBERNATE_CONFIGURATION_LOCATION = "hibernate.cfg.xml";  
    private static final String MAPPINGS_LOCATION = "src/main/resources/mappings";
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(HIBERNATE_CONFIGURATION_LOCATION).addDirectory(new File(MAPPINGS_LOCATION));
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;          
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSIONFACTORY;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }   
}