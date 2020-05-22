private void genererScript(Class<?>... classes) {

    StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
            .applySetting(Environment.DIALECT, entityManagerFactory.getProperties().get(DIALECT_PROPERTY).toString())
            .build();

    MetadataSources sources = new MetadataSources( standardRegistry );
    for (Class<?> entityClass : classes) {
        sources.addAnnotatedClass(entityClass);
    }

    MetadataImplementor metadata = (MetadataImplementor) sources
            .getMetadataBuilder()
            .build();

    EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.SCRIPT);

    try {
        Files.delete(Paths.get(getScriptPath()));
    } catch (IOException e) {
        /*
         * The file did not exist...
         * we do nothing.
         */
    }

    SchemaExport schemaExport = new SchemaExport();
    schemaExport.setDelimiter(SCRIPT_DELIMITER);
    schemaExport.setOutputFile(getScriptPath());
    schemaExport.setFormat(true);
    schemaExport.createOnly(targetTypes, metadata);
}