String message = "";


try {
    URL url = new URL("working-url");
    URLConnection urlConn = url.openConnection();
    urlConn.setReadTimeout(100000);
    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
    String line;

    while ((line = reader.readLine()) != null) {
        message = message.concat(line);
    }
    reader.close();

} catch (MalformedURLException e) {
message = e.getMessage();
} catch (IOException e) {
message = e.getMessage();
}