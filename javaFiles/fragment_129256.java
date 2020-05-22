java.awt.image.DataBuffer dataBuffer = new java.awt.image.DataBufferByte(
    imageIndiciesIntoPalette, imageIndiciesIntoPalette.length);

SampleModel sampleModel = new java.awt.image.SinglePixelPackedSampleModel(
    DataBuffer.TYPE_BYTE, sourceImage.getWidth(), sourceImage.getHeight(), 
    new int[]{0xff});

// Create a raster using the sample model and data buffer
WritableRaster raster = Raster.createWritableRaster(sampleModel, dataBuffer, null);

// Combine the color model and raster into a buffered image
BufferedImage finalImage = new BufferedImage(palette, raster, false, null);
ImageIO.write(finalImage, "gif", new File(targetImageFileName));