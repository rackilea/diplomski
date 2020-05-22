JSONArray routes = jsonObject.getJSONArray("routes");
JSONObject object = routes.getJSONObject(0);
JSONArray legs = object.getJSONArray("legs");
JSONObject legsObjects = legs.getJSONObject(0);

//get the distance
JSONObject distance = legsObjects.getJSONObject("distance");
String distance = distance.getString("text");

//get the time
JSONObject time = legsObjects.getJSONObject("duration");
String duration = time.getString("text");