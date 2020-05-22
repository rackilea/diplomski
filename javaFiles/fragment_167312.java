Configuration config = new Configuration();
    config.addAnnotatedClass(Class1.class);
    config.addAnnotatedClass(Class2.class);
    config.addAnnotatedClass(Class3.class);
    <set all hibernate properties/datasource here>
    SchemaExport schema = new SchemaExport(config);
    schema.create(true, true);