public static byte[] stringToByte(String text) {
  final String[] split = text.split("\\s+");
  final byte[] result = new byte[split.length];
  int i = 0;
  for (String b : split) result[i++] = (byte)Integer.parseInt(b, 16);
  return result;
}