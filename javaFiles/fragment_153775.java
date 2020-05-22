public static String getHTML(URL url) {
    try {
        final URLConnection urlConnection = url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Foo?");
        final InputStream inputStream = urlConnection.getInputStream();
        final String html = IOUtils.toString(inputStream);
        inputStream.close();
        return html;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }