public class JpaUtil {

private static HashMap<String, String> properties = new HashMap<String, String>();
private volatile static EntityManagerFactory factory;

static {
    properties.put("javax.persistence.jdbc.driver", System.getProperty("DRIVER"));
    properties.put("javax.persistence.jdbc.user", System.getProperty("USER"));
    properties.put("javax.persistence.jdbc.password", System.getProperty("PASSWORD"));
    properties.put("javax.persistence.jdbc.url", System.getProperty("DATABASEURL"));
}

private static EntityManagerFactory getInstance() {
    if (factory == null) {
        synchronized (EntityManagerFactory.class) {
            if (factory == null) {

                factory = Persistence.createEntityManagerFactory("PU", properties);
            }
        }
    }
    return factory;
}

public static EntityManager getEntityManager() throws Exception {
    return getInstance().createEntityManager();
}

}