ByteInterleavedRaster srcRaster = (ByteInterleavedRaster)src.getRaster();
byte srcData[] = srcRaster.getDataStorage();

IntegerInterleavedRaster dstRaster = (IntegerInterleavedRaster)dst.getRaster();
int dstData[] = dstRaster.getDataStorage();

dstData[0] = srcData[0] << 16 | srcData[1] << 8 | srcData[2];