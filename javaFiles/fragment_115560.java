if (endian.equals(ByteOrder.nativeOrder())){
    interimByteBuffer = ByteBuffer.allocateDirect(doubleGeomByteArray.length);
    dbb = interimByteBuffer.asDoubleBuffer();
    interimByteBuffer.put(doubleGeomByteArray);
}
else{
    interimByteBuffer = ByteBuffer.wrap(doubleGeomByteArray).order(endian);
    dbb = ByteBuffer.allocateDirect(numOfPoints * 2 * 8).order(ByteOrder.nativeOrder()).asDoubleBuffer();
    while(interimByteBuffer.hasRemaining()) {
        dbb.put(interimByteBuffer.getDouble());
    }
    dbb.flip();
}