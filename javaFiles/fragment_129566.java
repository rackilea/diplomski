JSONArray jsonObject1 = (JSONArray) jb.get("rows");
JSONObject jsonObject2 = (JSONObject)jsonObject1.get(0);
JSONArray jsonObject3 = (JSONArray)jsonObject2.get("elements");
JSONObject elementObj = (JSONObject) jsonObject3.get(0);
JSONObject distanceObj = (JSONObject)elementObj.get("distance");
String distance = distanceObj.getString("text");