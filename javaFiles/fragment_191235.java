JSONObject json = new JSONObject(someJson);
try {
  JSONArray payload = json.getJSONArray("payload");
} catch (Exception e) {
  // array conversion can fail for single object 
  JSONObject payload = json.getJSONObject("payload");
}