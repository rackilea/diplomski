public String getURLcontents(URL url) throws IOException{
    String response = "failed";
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    Log.v(TAG, "Opening connection: " + url.toString());
    try {
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        response = new Scanner(in).useDelimiter("\\A").next();
    }
    catch (Exception e) {
        urlConnection.disconnect();
        return response = "failed";
    }
    finally {
        urlConnection.disconnect();
        Log.v(TAG, "Closed connection");
    }
    return response;
}