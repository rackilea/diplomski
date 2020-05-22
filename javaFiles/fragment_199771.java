public static String readFile(Path p) throws IOException {
  byte[] bytes = Files.readAllBytes(p);
  boolean isUtf8 = false;
  for (byte b : bytes) {
    if (b == -61) {
      isUtf8 = true;
      break;
    }
  }
  return new String(bytes, isUtf8 ? StandardCharsets.UTF_8 : StandardCharsets.ISO_8859_1);
}