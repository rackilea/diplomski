Metadata metadata = MetadataExtractorIntegrator.INSTANCE.getMetadata();

for ( PersistentClass persistentClass : metadata.getEntityBindings()) {

    Table table = persistentClass.getTable();

    LOGGER.info( "Entity: {} is mapped to table: {}",
                 persistentClass.getClassName(),
                 table.getName()
    );

    for(Iterator propertyIterator = persistentClass.getPropertyIterator(); 
            propertyIterator.hasNext(); ) {
        Property property = (Property) propertyIterator.next();

        for(Iterator columnIterator = property.getColumnIterator(); 
                columnIterator.hasNext(); ) {
            Column column = (Column) columnIterator.next();

            LOGGER.info( "Property: {} is mapped on table column: {} of type: {}",
                         property.getName(),
                         column.getName(),
                         column.getSqlType()
            );
        }
    }
}