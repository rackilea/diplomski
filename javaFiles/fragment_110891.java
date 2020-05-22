public String lastEvent(String event) throws ClientProtocolException, IOException, JSONException {
    StringBuilder url = new StringBuilder(URL);

    HttpGet get = new HttpGet(url.toString());
    HttpResponse response = client.execute(get);

    int status = response.getStatusLine().getStatusCode();

    if ( status == 200 ) {
        HttpEntity entity = response.getEntity();
        String data = EntityUtils.toString(entity);
        // data now contains the json object I posted above
        // So we fetch it
        JSONObject timeline = new JSONObject(data);
        // We want the features array
        JSONArray features = timeline.getJSONArray("features");
        // The first element
        JSONObject first = timeline.getJSONObject(0);
        // The titles attribute. I assume lastEvent("titles")
        // is the way you call this function
        String last = first.getString(event);

        return last;
    }
    else {
        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT);
        return null;
    }
}