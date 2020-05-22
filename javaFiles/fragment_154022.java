try {
    URL url = new URL(strings[0]);
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

    int responseCode = urlConnection.getResponseCode();
    Log.i(TAG, "POST Response Code: " + responseCode);

    //Takes data only if response from WebService is OK
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        //Stores input line by line in response
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //get data in JSON
        JSONObject object = new JSONObject(response.toString());
        title = object.getString("original_title");

        urlConnection.disconnect();
        Log.d("titlenya", title);

    }
} catch (IOException | JSONException e) {
    e.printStackTrace();
}