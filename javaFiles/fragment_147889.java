SimpleFeatureSource source = dataStore.getFeatureSource(typeName);

    FeatureType schema = source.getSchema();
    String name = schema.getGeometryDescriptor().getLocalName();

    Filter filter = CQL.toFilter(text.getText());

    Query query = new Query(typeName, filter, new String[] { name });

    SimpleFeatureCollection features = source.getFeatures(query);