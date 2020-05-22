private static final Charset[] UTF_ENCODINGS = { Charset.forName("UTF-8"),
      Charset.forName("UTF-16LE"), Charset.forName("UTF-16BE") };

  private static Charset getEncoding(InputStream in) throws IOException {
    charsetLoop: for (Charset encodings : UTF_ENCODINGS) {
      byte[] bom = "\uFEFF".getBytes(encodings);
      in.mark(bom.length);
      for (byte b : bom) {
        if ((0xFF & b) != in.read()) {
          in.reset();
          continue charsetLoop;
        }
      }
      return encodings;
    }
    return Charset.defaultCharset();
  }

  private static String readText(File file) throws IOException {
    Closer res = new Closer();
    try {
      InputStream in = res.using(new FileInputStream(file));
      InputStream bin = res.using(new BufferedInputStream(in));
      Reader reader = res.using(new InputStreamReader(bin, getEncoding(bin)));
      StringBuilder out = new StringBuilder();
      for (int ch = reader.read(); ch != -1; ch = reader.read())
        out.append((char) ch);
      return out.toString();
    } finally {
      res.close();
    }
  }