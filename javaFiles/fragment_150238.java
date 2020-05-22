JSONObject objectInArray = new JSONObject();
objectInArray.put("id", "some value");
objectInArray.put("name", "some value");
JSONArray jsonArray = new JSONArray();
jsonArray.add(objectInArray);
JSONObject data = new JSONObject();
data.put("data", jsonArray);