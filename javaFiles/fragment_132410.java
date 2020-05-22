List<Class<?>> classes = EntityScanner
        .scanPackages("my.com.entities", "my.com.other.entities").result();

MetadataSources metadataSources = new MetadataSources();
for (Class<?> annotatedClass : classes) {
    metadataSources.addAnnotatedClass(annotatedClass);
}

SessionFactory sessionFactory = metadataSources.buildMetadata()
    .buildSessionFactory();