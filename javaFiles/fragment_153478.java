//your existing code..

HttpURLConnection client = null;

try{
    URL url = new URL(web);
    client = (HttpURLConnection) url.openConnection();

    InputStream in = new BufferedInputStream(client.getInputStream());
    readStream(in);

} catch (MalformedURLException e) {
     //bad  URL, tell the user
} catch (IOException e) {
     //network error/ tell the user
} finally  {
     client.disconnect();
}