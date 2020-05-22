JSONObject descriptionJson = null;
JSONArray jsonArray1 = jsonObj3.getJSONArray("ASSET");
if (jsonArray1 != null && !jsonArray1.isEmpty()) {
    JSONObject asset = jsonArray1.getJSONObject(0);
    JSONObject attributesObj = asset.getJSONObject("ATTRIBUTE");
    descriptionJson = attributesObj.getJSONObject("DESCRIPTION");
}
if (descriptionJson != null) {
    //Do your processing here.
}