try {
    URL url = new URL("http://www.yoursite.com/");
    URLConnection conn = url.openConnection();
    conn.connect();
} catch (MalformedURLException e) {
    // the URL is not in a valid form
} catch (IOException e) {
    // the connection couldn't be established
}