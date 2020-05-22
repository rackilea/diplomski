ByteBuffer bb = ByteBuffer.wrap(byteArray);
bb.order( ByteOrder.LITTLE_ENDIAN);
while( bb.hasRemaining()) {
   short v = bb.getShort();
   /* Do something with v... */
}