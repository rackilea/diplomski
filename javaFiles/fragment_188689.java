private static String readFile(String path) throws IOException {
  FileInputStream stream = new FileInputStream(new File(path));
  try {
    FileChannel fc = stream.getChannel();
    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
    /* Instead of using default, pass in a decoder. */
    return Charset.defaultCharset().decode(bb).toString();
  }
  finally {
    stream.close();
  }
}