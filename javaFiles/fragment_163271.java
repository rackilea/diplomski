//JSONObject reader = new JSONObject(result); not required
JSONArray jArray = new JSONArray(result);
for (int i = 0; i < jArray.length(); i++) {
     json_data = jArray.getJSONObject(i);
     System.out.println("Testing ID : " + json_data.optString("id"));
}// use optString, no exception and auto parsing