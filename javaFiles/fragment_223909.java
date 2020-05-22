JSONArray routesArray = resultObj.getJSONArray("routes");
for(int i = 0; i < routesArray.length(); i++) {
    JSONObject obj = routesArray.optJSONObject(i);
    if(obj != null) {
        JSONObject polyline = obj.optJSONObject("overview_polyline");
    }
}