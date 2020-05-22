ByteBuffer byteBuffer = ByteBuffer.allocate(4);
byteBuffer.put((byte)0);
byteBuffer.put((byte)0);
byteBuffer.put((byte)1);
byteBuffer.put((byte)-14);
byteBuffer.rewind();
int bodyLength = byteBuffer.getInt();
System.out.println(bodyLength);