SessionFactory sessionFactory;
  Configuration config = new AnnotationConfiguration()
                         .configure("hibernate.cfg.xml")
                         .setNamingStrategy( new MyNamingStrategy () );
  sessionFactory = config.buildSessionFactory();
  session = sessionFactory.openSession();