public JSONObject queryGoogleDistanceApi(String origin, String destination, String API_KEY_PLACES) throws Exception{
    String Url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination + "&mode=driving&language=en&key=" + API_KEY_PLACES;

    HttpURLConnection conn = null;
    StringBuilder jsonResults = new StringBuilder();
    URL url = new URL(Url);
    Log.d(TAG, Url);
    conn = (HttpURLConnection) url.openConnection();
    InputStreamReader in = new InputStreamReader(conn.getInputStream());
    // Load the results into a StringBuilder
    int read;
    char[] buff = new char[1024];
    while ((read = in.read(buff)) != -1) {
        jsonResults.append(buff, 0, read);
    }
    if (conn != null) {
        conn.disconnect();
    }

    JSONObject object = new JSONObject(jsonResults.toString());
    return object;
}