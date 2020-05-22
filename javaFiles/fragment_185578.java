private InputStream downloadUrl(String urlString) throws IOException
{
    URL url = new URL(urlString);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setReadTimeout(10000);
    conn.setConnectTimeout(15000);
    conn.setRequestMethod("GET");
    conn.setDoInput(true);

    //start the query
    conn.connect();
    InputStream stream = conn.getInputStream();
    return stream;
}