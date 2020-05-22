JSONObject myObject = new JSONObject(jsonStr);
JSONArray myArray = myObject.getJSONArray("data");
JSONObject obj = myArray.getJSONObject(0);
String id = obj.getString("id");
String type = obj.getString("type");

//change the lines bellow
JSONObject attributes = obj.getJSONObject("attributes");
JSONObject avatar = attributes.getJSONObject("avatar");
String large = avatar.getString("large");