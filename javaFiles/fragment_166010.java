static byte[] intToBytesBigEndian(int i) {
  return new byte[] {
    (byte) ((i >>> 24) & 0xff),
    (byte) ((i >>> 16) & 0xff),
    (byte) ((i >>> 8) & 0xff),
    (byte) (i & 0xff),
  };
}