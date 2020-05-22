try {
    JSONArray array = new JSONArray(locations);
    for(int i = 0; i < array.length(); i++) {
        JSONObject json = array.getJSONObject(i);
        GeoPoint p = new GeoPoint(json.getInt("lat"), json.getInt("lon"));
        overlay.addItem(p, "location", "location");
    }
} catch (JSONException ex) {
    Log.e("debug", ex.getMessage());
}