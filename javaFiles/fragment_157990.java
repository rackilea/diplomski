private static final String BOM = "\ufeff";

  public static void main(String[] args) throws IOException {
    String data = "\u250c\u2500\u2500\u2510\r\n\u251c\u2500\u2500\u2524";
    OutputStream out = new FileOutputStream("data.txt");
    Closeable resource = out;
    try {
      Writer writer = new OutputStreamWriter(out, Charset.forName("UTF-8"));
      resource = writer;
      writer.write(BOM);
      writer.write(data);
    } finally {
      resource.close();
    }
  }