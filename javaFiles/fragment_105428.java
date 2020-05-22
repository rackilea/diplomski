public static int getResponseCode(URL url) throws IOException {
  URLConnection conn = url.openConnection();
  if (!(conn instanceof HttpURLConnection)) {
    throw new IllegalArgumentException("not an HTTP url: " + url);
  }
  HttpURLConnection httpConn = (HttpURLConnection) conn;
  return httpConn.getResponseCode();
}