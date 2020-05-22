public static String escape(byte[] data) {
    StringBuilder cbuf = new StringBuilder();
    for (byte b : data) {
      if (b >= 0x20 && b <= 0x7e) {
        cbuf.append((char) b);
      } else {
        cbuf.append(String.format("\\0x%02x", b & 0xFF));
      }
    }
    return cbuf.toString();
  }