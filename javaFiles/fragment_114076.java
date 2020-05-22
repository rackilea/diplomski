final Configuration configuration = new Configuration();
    final Reflections reflections = new Reflections(Item.class.getPackage().getName());
    final Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
    for (final Class<?> clazz : classes) {
        configuration.addAnnotatedClass(clazz);
    }
            ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings
(configuration.getProperties()).buildServiceRegistry();        

    return configuration.buildSessionFactory(serviceRegistry);