private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
  private static SessionFactory sessionFactory;

  static {
    try {
      sessionFactory = configureSessionFactory();
    } catch (Exception e) {
      System.err.println("%%%% Error Creating SessionFactory %%%%");
      e.printStackTrace();
    }
  }

  private HibernateUtil() {
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static Session getSession() throws HibernateException {
    Session session = threadLocal.get();

    if (session == null || !session.isOpen()) {
      if (sessionFactory == null) {
        rebuildSessionFactory();
      }
      session = (sessionFactory != null) ? sessionFactory.openSession() : null;
      threadLocal.set(session);
    }

    return session;
  }

  public static void rebuildSessionFactory() {
    try {
      sessionFactory = configureSessionFactory();
    } catch (Exception e) {
      System.err.println("%%%% Error Creating SessionFactory %%%%");
      e.printStackTrace();
    }
  }

  public static void closeSession() throws HibernateException {
    Session session = (Session) threadLocal.get();
    threadLocal.set(null);

    if (session != null) {
      session.close();
    }
  }