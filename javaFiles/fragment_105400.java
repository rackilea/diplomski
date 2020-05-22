//Json object
String json = '{"myid":"123","post":"harry"}';
JSONObject jobj = new JSONObject(json);
String id = jobj.getString("myid");

//Json Array
String json = '[{"myid":"123","post":"harry"},{"myid":"456":"ramon"}]';
JSONArray jarr = new JSONArray(json);
JSONObject jobj = jarr.getJSONObject(0);
String id = jobj.getString("myid");