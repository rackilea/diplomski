JSONObject jObject = new JSONObject(JSONdata);

JSONArray jdata = jObject.getJSONArray("data");

JSONObject job = jdata.getJSONObject(0);
JSONObject jObjt = job.getJSONObject("track");
String temp = jObjt.getString("imageurl");
Log.e("rid",temp);