try {
    URL url = new URL(your_url_address);
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();

        //Parse Response
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());

    } finally {
        urlConnection.disconnect();
    }
} catch(Exception e) {
    Log.e("ERROR", e.getMessage(), e);
}