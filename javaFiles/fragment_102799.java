connection = (HttpURLConnection) new URL(url).openConnection();
/* ... */
final int responseCode = connection.getResponseCode();
switch (responseCode) {
  case 404:
  /* ... */
  case 200: {
    InputStream input = new BufferedInputStream(url.openStream());
    /* ... */
  }
}