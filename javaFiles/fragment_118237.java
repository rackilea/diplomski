private static void writeUtf8ToFile(File file, boolean append, String data)
    throws IOException {
  boolean skipBOM = append && file.isFile() && (file.length() > 0);
  Closer res = new Closer();
  try {
    OutputStream out = res.using(new FileOutputStream(file, append));
    Writer writer = res.using(new OutputStreamWriter(out, Charset.forName("UTF-8")));
    if (!skipBOM) {
      writer.write('\uFEFF');
    }
    writer.write(data);
  } finally {
    res.close();
  }
}