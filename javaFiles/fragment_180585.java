private void getRoadName(String lat, String lng) {

    String roadName = "";
    String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=__LAT__,__LNG__&sensor=false";

    url = url.replaceAll("__LAT__", lat);
    url = url.replaceAll("__LNG__", lng);

    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
    HttpGet httpget = new HttpGet(url);

    InputStream inputStream = null;
    String result = null;
    try {
        HttpResponse response = httpclient.execute(httpget);           
        HttpEntity entity = response.getEntity();

        inputStream = entity.getContent();
        // json is UTF-8 by default
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
        StringBuilder sb = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line + "\n");
        }
        result = sb.toString();
    } catch (Exception e) { 
        // Oops
    }
    finally {
        try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
    }        

    JSONObject jObject = new JSONObject(result);
    JSONArray jArray = jObject.getJSONArray("results");
    if (jArray != null && jArray.size > 0) {
        try {
            JSONObject oneObject = jArray.getJSONObject(i);
            // Pulling items from the array
            roadName = oneObject.getString("formatted_address");
        } catch (JSONException e) {
        // Oops
        }
    }
}