HttpURLConnection urlConnection = null;
URL url = null;
JSONObject object = null;
InputStream inStream = null;
try {
    url = new URL(urlString.toString());
    urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.setDoOutput(true);
    urlConnection.setDoInput(true);
    urlConnection.connect();
    inStream = urlConnection.getInputStream();
    BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
    String temp, response = "";
    while ((temp = bReader.readLine()) != null) {
        response += temp;
    }
    object = (JSONObject) new JSONTokener(response).nextValue();
} catch (Exception e) {
    this.mException = e;
} finally {
    if (inStream != null) {
        try {
            // this will close the bReader as well
            inStream.close();
        } catch (IOException ignored) {
        }
    }
    if (urlConnection != null) {
        urlConnection.disconnect();
    }
}