ByteBuffer imageData = ByteBuffer.allocateDirect(height * width * 4);
byte[] raw = new byte[width * height * 4];
imageData.get(raw);
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
DataBuffer buffer = new DataBufferByte(raw, raw.length);
SampleModel sampleModel = new ComponentSampleModel(
        DataBuffer.TYPE_BYTE, width, height, 4, width * 4,
        new int[]{2,1,0} // Try {1,2,3}, {3,2,1}, {0,1,2}
);
Raster raster = Raster.createRaster(sampleModel, buffer, null);
image.setData(raster);