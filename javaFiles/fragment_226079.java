StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
            .configure()
            .build();

        Metadata metadata = new MetadataSources(standardRegistry)
            .addAnnotatedClass(NodeType.class)
            .getMetadataBuilder()
            .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
            .build();

        sessionFactory = metadata
            .getSessionFactoryBuilder()
            .build();