SampleModel sampleModel =
  RasterFactory.createBandedSampleModel(DataBuffer.TYPE_FLOAT,  width,height,1);
  // Create a compatible ColorModel.
  ColorModel colorModel = PlanarImage.createColorModel(sampleModel);

 Raster raster = RasterFactory.createWritableRaster(sampleModel,dbuffer, new Point(0,0));
  // Create a TiledImage using the float SampleModel.
  TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,
  sampleModel,colorModel);
  // Set the data of the tiled image to be the raster.
  tiledImage.setData(raster);
  // Save the image on a file.
  JAI.create("filestore",tiledImage,"floatpattern.tif","TIFF");