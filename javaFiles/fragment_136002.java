private String getJSONFromURLConnection(String urlString) {
    BufferedReader reader = null;

    try {
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();

        String apikey = YOUR_KEY;
        urlConnection.setRequestMethod("GET");
        urlConnection.addRequestProperty("Authorization", "Bearer " + apikey);
        urlConnection.setRequestProperty("Accept", "application/json");

        if (urlConnection.getResponseCode() == 200) {
            InputStream stream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line;

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            return buffer.toString();
        } else {
            Log.e("Error", "Error response code: " +
                    urlConnection.getResponseCode());
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (urlConnection != null)
            urlConnection.disconnect();
    }
    return null;
}