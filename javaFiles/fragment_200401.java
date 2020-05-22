FileDataStore dataStore = FileDataStoreFinder.getDataStore(shpFile);
    SimpleFeatureSource shapefileSource = dataStore.getFeatureSource();       
    Style shpStyle = SLD.createPolygonStyle(Color.RED, null, 0.0f);
    Layer shpLayer = new FeatureLayer(shapefileSource, shpStyle);       
    map.addLayer(shpLayer);
    show();    
 }
 public void addraster(File rasterFile) throws Exception {         
    AbstractGridFormat format = GridFormatFinder.findFormat( rasterFile );
    reader = format.getReader(rasterFile);     
    Style rasterStyle = createGreyscaleStyle(1);      
    Layer rasterLayer = new GridReaderLayer(reader, rasterStyle);
    map.addLayer(rasterLayer);        
    show();
    }