byte[] bytes = new byte[16];
 ByteBuffer bb = ByteBuffer.wrap(bytes);
 bb.order(ByteOrder.LITTLE_ENDIAN or ByteOrder.BIG_ENDIAN);
 bb.putLong(UUID.getMostSignificantBits());
 bb.putLong(UUID.getLeastSignificantBits());

 // to reverse
 bb.flip();
 UUID uuid = new UUID(bb.getLong(), bb.getLong());