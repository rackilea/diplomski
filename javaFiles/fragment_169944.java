// before loop
byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

// in loop
long bigIndex = byteBuffer.getLong();
byteBuffer.rewind();
System.out.println("INDEX "+Long.toHexString(bigIndex));