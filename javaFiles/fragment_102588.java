public static byte[] hexToBytes(final String hex) {
  final byte[] bytes = new byte[hex.length() / 2];
  for (int i = 0; i < bytes.length; i++) {
    bytes[i] = (byte) Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16);
  }
  return bytes;
}