JSONObject json = new JSONArray(jsonString).getJSONObject(0); 
// or JSONObject json = new JSONObject(jsonString).getJSONObject("1");
success = json.getBoolean("success");
object = json.getString("object");
message = json.getString("message");

data = json.getJSONArray("data")