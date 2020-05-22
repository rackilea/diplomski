DataRasterReaderFactory readerFactory = (DataRasterReaderFactory) WorldWind
                .createConfigurationComponent(AVKey.DATA_RASTER_READER_FACTORY_CLASS_NAME);
DataRasterReader dataRasterReader;
DataRaster[] dataRasters = null;
...
dataRasterReader = readerFactory.findReaderFor(file, null);
dataRasters = dataRasterReader.read(file, null);
...
rasterGdal = (ExtendedGDALDataRaster) dataRasters[0];

ElevationModel elevationModelFromGlobe = GLOBE.getElevationModel(); 
Sector boundingSector = rasterGdal.getSector();
int[] heightAndWidth = new int[2];  

// Method for creating an empty sector by analogy with the current one  
recalculationHeightAndWidth (boundingSector, elevationModelFromGlobe, heightAndWidth);


// Method to create default parameters for the sector
AVList params = getParams(boundingSector, heightAndWidth[1], heightAndWidth[0]);
raster = (ByteBufferRaster) ByteBufferRaster.createGeoreferencedRaster(params);

Dataset dataset = rasterGdal.getBestSuitedDataset(heightAndWidth[1], heightAndWidth[0], rasterGdal.getSector());
band = dataset.GetRasterBand(1);