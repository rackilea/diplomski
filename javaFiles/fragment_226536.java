static byte[] htoip(int ipv4) {
  return ByteBuffer.wrap(new byte[4])
                   .order(ByteOrder.nativeOrder())
                   .putInt(ipv4)
                   .array();
}