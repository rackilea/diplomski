JSONArray obj = new JSONArray(yourStringResponse);

// get the last object
JSONObject tot_obj = obj.getJSONObject(obj.length()-1);

// get String from last object
String tot_str = tot_obj.optString("total_attendance");