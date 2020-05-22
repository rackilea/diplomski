//here you create a ColorModel for your Image
ColorModel cm = source.createColorModel();
//then create a compatible SampleModel, with the tilesize
SampleModel sm = cm.createCompatibleSampleModel(tileWidth,tileHeight);

TiledImage image = new TiledImage(0, 0, imageWidth, imageHeight, 0, 0, sm, cm);