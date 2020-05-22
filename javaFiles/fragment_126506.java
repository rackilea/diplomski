byte[] bytes = getBytesFromWebService();
ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
GZIPInputStream gzip = new GZIPInputStream(bais);
try {
  InputStreamReader reader = new InputStreamReader(gzip, "UTF-8");
  try {
    String firstLine = new BufferedReader(reader).readLine();
    ...
  } finally {
    reader.close();
  }
} finally {
  gzip.close();
}