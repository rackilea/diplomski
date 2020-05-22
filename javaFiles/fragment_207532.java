for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject stations = jsonArray.getJSONObject(i);

    String station = stations.getString("station");
    String temperature = stations.getString("temperature");
    String temperature = stations.getString("windchill");
}