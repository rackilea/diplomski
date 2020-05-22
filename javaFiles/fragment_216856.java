private double getLat() throws IOException, JSONException {
        JSONObject myData = readFromJsonUrl();
        JSONArray results = myData.getJSONArray("results");
        JSONObject geometry = results.getJSONObject(0).getJSONObject("geometry");
        JSONObject location = geometry.getJSONObject("location");
        double lat = location.getDouble("lat");
        return lat;
    }