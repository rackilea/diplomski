import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a method to get Session Factory object.
 */
public class HibernateUtil {
private static final SessionFactory sessionFactory;//Once created, its properties cannot be changed

static {
    try {
        // Create the SessionFactory from standard (hibernate.cfg.xml) config file.

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    } catch (Throwable ex) {

        // Log the exception.
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

public static SessionFactory getSessionFactory() {

    return sessionFactory;

}
}