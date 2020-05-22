public static byte[] convert(int i) {
    return new byte[]{ (i & 0xff0000) >> 16, (i & 0xff00) >> 8, (i & 0xff) };
  }

  public static int convert(byte[] b) {
    if (b == null && b.length != 3)
      throw new IllegalArgumentException();

      return (b[2] << 16) | (b[1] << 8) | b;
  }