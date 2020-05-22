String serverURL = "http://192.168.0.150/main_light/switch";
URL url = new URL(serverURL);
HttpURLConnection connection = null;
try {
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
    //Do something with this InputStream
    // handle the response
    int status = connection.getResponseCode();
    // If response is not success
    if (status != 200) {
        throw new IOException("Post failed with error code " + status);
    }
} catch (Exception e) {
    Log.e(TAG,e.toString());
} finally {
     if(connection != null)
         connection.disconnect();
}