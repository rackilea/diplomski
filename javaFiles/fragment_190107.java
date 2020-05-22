URL url = new URL("http://example.com");
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setRequestMethod("GET");
connection.connect();

InputStream stream = connection.getInputStream();
// read the contents using an InputStreamReader