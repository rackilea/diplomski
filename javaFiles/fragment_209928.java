public void testConnection() throws Exception {

            logger.info("Trying to create a test connection with the database.");
            Configuration configuration = new Configuration();
            configuration.configure("hibernate_sp.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();
            logger.info("Test connection with the database created successfuly.");
    }