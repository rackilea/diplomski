JSONObject jsonobject = new JSONObject(response);
JSONArray jsonarray = jsonobject.getJSONArray("users");
JSONObject data = jsonArray.getJSONObject(0);

String firstName = data.getString("firstName");
String lastName = data.getString("lastName");