EntityManagerFactoryImpl emf=(EntityManagerFactoryImpl)lcemfb.getNativeEntityManagerFactory();
SessionFactoryImpl sf=emf.getSessionFactory();
StandardServiceRegistry serviceRegistry = sf.getSessionFactoryOptions().getServiceRegistry();
MetadataSources metadataSources = new MetadataSources(new BootstrapServiceRegistryBuilder().build());
Metadata metadata = metadataSources.buildMetadata(serviceRegistry);
SchemaUpdate update=new SchemaUpdate(serviceRegistry,metadata); //To create SchemaUpdate

// You can either create SchemaExport from the above details, or you can get the existing one as follows:
try {
    Field field = SessionFactoryImpl.class.getDeclaredField("schemaExport");
    field.setAccessible(true);
    SchemaExport schemaExport = (SchemaExport) field.get(serviceRegistry);
} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
    e.printStackTrace();
}