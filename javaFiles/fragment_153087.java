/*
     * Get an output file name and create the new shapefile
     */
    File newFile = getNewShapeFile(file);

    ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();

    Map<String, Serializable> params = new HashMap<String, Serializable>();
    params.put("url", newFile.toURI().toURL());
    params.put("create spatial index", Boolean.TRUE);

    ShapefileDataStore newDataStore = (ShapefileDataStore) dataStoreFactory.createNewDataStore(params);
    newDataStore.createSchema(TYPE);

    /*
     * You can comment out this line if you are using the createFeatureType method (at end of
     * class file) rather than DataUtilities.createType
     */
    newDataStore.forceSchemaCRS(DefaultGeographicCRS.WGS84);