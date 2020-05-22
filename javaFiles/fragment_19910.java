int width = 256;
int height = 256;
ByteBuffer bb = ByteBuffer.allocateDirect(height*width*3);

byte[] raw = new byte[width * height * 3];
bb.get(raw);
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
DataBuffer buffer = new DataBufferByte(raw, raw.length);
SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, width, height, 3, width * 3, new int[]{0,1,2});
Raster raster = Raster.createRaster(sampleModel, buffer, null);
image.setData(raster);