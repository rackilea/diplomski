import org.hibernate.Session;

public class BaseSessionFactory {

    public static void closeSession(final Session session) {
        if (session != null && session.isOpen()) {
            try {
                session.close();
            } catch (Exception e) {
                // LOG.error("Failed to close session: " + e.toString());
            }
        }
    }

}