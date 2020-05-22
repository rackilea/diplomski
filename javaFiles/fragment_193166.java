try {
    JSONObject jObj = new JSONObject(myGeocoder.jsonResult);
    String Status = jObj.getString("status");
    if (Status.equalsIgnoreCase("OK")) {
        JSONArray results = jObj.getJSONArray("results");
        JSONObject item = results.getJSONObject(0);//read first item of results
        JSONObject geometry = item.getJSONObject("geometry");//location is inside geometry object
        JSONObject location = geometry.getJSONObject("location");
        double latitude = location.getDouble("lat");
        double longitude = location.getDouble("lng");
        //or
        LatLng latLng = new LatLng(latitude, longitude);
    }
} catch (JSONException e) {
    e.printStackTrace();
}