private static String getUrlSource(String url) throws MalformedURLException, IOException {
    URL localUrl = null;
    localUrl = new URL(url);
    URLConnection conn = localUrl.openConnection();
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream()));
    String line = "";
    String html;
    StringBuilder ma = new StringBuilder();
    while ((line = reader.readLine()) != null) {
        ma.append(line);
    }
    return ma.toString();
}