private static String encrypt(InputStream file, String key) throws Exception {
    int read = 0;
    byte[] buffer = new byte[1024];
    try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      while((read = file.read(buffer)) > 0) {
        baos.write(buffer, 0, read);
      }
      return base64Encode(xorWithKey(baos.toByteArray(), key.getBytes()));
    }
  }

  private static String decrypt(String input, String key) {
    byte[] decoded = base64Decode(input);
    return new String(xorWithKey(decoded, key.getBytes()));
  }

  private static byte[] xorWithKey(byte[] a, byte[] key) {
    byte[] out = new byte[a.length];
    for (int i = 0; i < a.length; i++) {
      out[i] = (byte) (a[i] ^ key[i%key.length]);
    }
    return out;
  }

  private static byte[] base64Decode(String s) {
    return Base64.getDecoder().decode(s.trim());
  }

  private static String base64Encode(byte[] bytes) {
    return Base64.getEncoder().encodeToString(bytes);
  }