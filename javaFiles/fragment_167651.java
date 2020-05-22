public long countContent(URL feedurl) {
  CountingInputStream counter = null;
  try {
     HttpURLConnection con = (HttpURLConnection) feedurl.openConnection();
     counter = new CountingInputStream(con.getInputStream());
     String output = IOUtils.toString(counter);
     return counter.getByteCount();
  } catch (IOException ex) {
     throw new RuntimeException(ex);
  } finally {
     IOUtils.closeQuietly(counter);
  }
}