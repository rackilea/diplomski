JSONArray jsonArray = new JSONArray();
JSONArray jsonArray1 = new JSONArray();
try {
    for (int i = 0; i < jsonArray1.length(); i++) {
        JSONObject jsonObject = jsonArray1.getJSONObject(i);
        jsonArray.put(jsonObject);
    }
} catch (JSONException e) {
    e.printStackTrace();
}