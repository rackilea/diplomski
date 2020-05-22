long[] convertToLongArray(byte[] bArray) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(bArray);
    LongBuffer longBuffer = byteBuffer.asLongBuffer();
    long l[] = new long[longBuffer.capacity()];
    longBuffer.get(l);
    return l;
}