public class HibernateUtil {

private static final SessionFactory sessionFactory = buildSessionFactory();

private static SessionFactory buildSessionFactory() {
    try {

        File cfgFile = new File("pathToFile/hibernate.cfg.xml");

        return new AnnotationConfiguration().configure(cfgFile).buildSessionFactory();

    } catch (Throwable ex) {

        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}