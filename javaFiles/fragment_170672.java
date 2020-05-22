public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private SessionFactoryUtil() {}

    static {
       sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getInstance() { return sessionFactory; }

}