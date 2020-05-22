JSONObject descriptionJson = null;
if (jsonObj3.has("ASSET")) {
    JSONArray jsonArray1 = jsonObj3.getJSONArray("ASSET");
    if (jsonArray1.length() > 0) {
        JSONObject asset = jsonArray1.getJSONObject(0);
        JSONObject attributesObj = asset.getJSONObject("ATTRIBUTE");
        descriptionJson = attributesObj.getJSONObject("DESCRIPTION");
    }
}
if (descriptionJson != null) {
    //Do your processing here.
}