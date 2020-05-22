locations = locations.substring(1, locations.length()-1);
String[] points = locations.split(",");

JSONObject json;
GeoPoint p;
try {
    for (int i=0; i<points.length; i++) {
        json = new JSONObject(points[i]);
        // I guess the "getInt()"s here are the problem
        p = new GeoPoint(json.getInt("lat"), json.getInt("lon"));
        overlay.addItem(p, "location", "location");
    }
} catch (JSONException ex) {
    Log.e("debug", ex.getMessage());
}