private static final String INPUT_FILE = "C:\\Users\\mycsv.csv";
  private static final String OUTPUT_FILE = "C:\\Users\\myzip.csv.gz";

  public static void zip() throws IOException {
    byte[] buffer = new byte[2048];
    FileInputStream inputStream = new FileInputStream(INPUT_FILE);
    FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
    GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
    int length;
    while ((length = inputStream.read(buffer)) > 0) {
      gzipOutputStream.write(buffer, 0, length);
    }
    inputStream.close();
    gzipOutputStream.close();
  }