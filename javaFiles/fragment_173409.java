Configuration configuration = new Configuration();
configuration.addAnnotatedClass(Entity1.class);
ServiceRegistry serviceRegistry
            = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();            
sessionFactory = configuration.buildSessionFactory(serviceRegistry);