URL url = new URL("http://filer.example.com/pictures/" + list.get(0) + ".jpg");
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.connect();
if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
    // everything ok
    InputStream in = connection.getInputStream();
    // process stream
} else {
    // possibly error
}