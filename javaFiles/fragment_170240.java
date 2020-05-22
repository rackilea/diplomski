private static final String DEFAULT_ENCODING = "ISO-8859-1";

public static final String convert(final InputStream in) throws IOException {
  return convert(in, DEFAULT_ENCODING);
}

public static final String convert(final InputStream in, final String encoding) throws IOException {
  final ByteArrayOutputStream out = new ByteArrayOutputStream();
  final byte[] buf = new byte[2048];
  int rd;
  while ((rd = in.read(buf, 0, 2048) >= 0) {
    out.write(buf, 0, rd);
  }
  return new String(out.toByteArray(), 0, encoding);
}