private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        // Creating a registry
        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        // Create the MetadataSources
        MetadataSources sources = new MetadataSources(registry);

        // Create the Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        //or sessionFactory = sources.buildSessionFactory();


      } catch (Exception e) {
        e.printStackTrace();
        if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
      }
    }
    return sessionFactory;
  }

  //To shut down
 public static void shutdown() {
    if (registry != null) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }