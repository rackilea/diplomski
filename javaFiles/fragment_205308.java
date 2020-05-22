import java.io.File;
import java.net.URI;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryGroceries extends BaseSessionFactory {
    private static final Logger LOG = Logger.getLogger(SessionFactoryGroceries.class);
    private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;

private static URI configFile = null;
private static String configFileLocation = "";
private static Configuration configuration = null;
private static Long configurationFileTimestamp = null;

public void getPath() {
    configFileLocation = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "hibernate.cfg.xml";
}

/**
 * session factory will be rebuilded in the next call
 * 
 */

public static void setConfigFile(final String configFile) {
    try {
        if (configFile.startsWith("file:"))
            setConfigFile(new URI(configFile));
        else
            setConfigFile(new URI("file:" + configFile));
    } catch (Exception e) {
        LOG.error("Failed to set config file to " + configFile + ": bad URI");
    }
}

public static void setConfigFile(final URI configURI) {
    SessionFactoryGroceries.configFile = configURI;
    sessionFactory = null;
}

/**
 * Returns the ThreadLocal Session instance. Lazy initialize the
 * <code>SessionFactory</code> if needed.
 * 
 * @return Session
 * @throws HibernateException
 */

public static synchronized Session getCurrentSession() {
    SessionFactoryGroceries groceries = new SessionFactoryGroceries();
    groceries.getPath();
    if (didConfigFileChange())
        resetFactory();

    Session session = (Session) THREAD_LOCAL.get();

    if (session == null || !session.isOpen()) {
        if (sessionFactory == null)
            rebuildSessionFactory();

        if (sessionFactory == null)
            session = null;
        else
            session = SessionEx.create(sessionFactory.openSession());

        THREAD_LOCAL.set(session);
    }

    if (session == null)
        throw new RuntimeException("unable to create hibernate session to database.");

    return session;
}

/**
 * Rebuild hibernate session factory
 * 
 */

@SuppressWarnings("deprecation")
public static void rebuildSessionFactory() {
    try {
        LOG.debug("XSpace configuring hibernate from this file: " + configFile);

        File file = new File(configFile);

        if (file.exists() == false)
            throw new RuntimeException("Could not find config file at location: " + configFile);

        configuration = new Configuration();
        configuration.configure(file);
        sessionFactory = configuration.buildSessionFactory();
    } catch (Exception e) {
        LOG.error("%%%% Error Creating SessionFactory %%%%", e);
        e.printStackTrace();
    } catch (Throwable e) {
        LOG.error("%%%% Error Creating SessionFactory %%%%", e);
        e.printStackTrace();
    }
}

private static Boolean didConfigFileChange() {
    if (configFile == null)
        setConfigFile(configFileLocation); // IF NULL USE THE DEFAULT LOCATION.

    File file = new File(configFile);

    if (file.exists() == false)
        throw new RuntimeException("could not find configuration file! " + configFile);

    Boolean changed = Boolean.FALSE;
    Long currentTimestamp = file.lastModified();

    if (configurationFileTimestamp == null) {
        configurationFileTimestamp = currentTimestamp;
    } else {
        if (configurationFileTimestamp.equals(currentTimestamp) == false) {
            configurationFileTimestamp = currentTimestamp;
            changed = true;
        }
    }

    return changed;
}

private static void resetFactory() {
    Session session = (Session) THREAD_LOCAL.get();

    if (session != null) {
        session.close();
    }

    THREAD_LOCAL.set(null);

    final org.hibernate.SessionFactory factory = sessionFactory;

    // wait 10 minutes then close the factory and any open connections on the old factory

    new Thread() {
        public void run() {
            synchronized (this) {
                try {
                    Thread.sleep(1000 * 60 * 10);
                    factory.close();
                } catch (Exception e) {
                    // don't care
                }
            }
        }
    }.start();

    sessionFactory = null;
}