JSONObject json = new JSONObject(data);
 JSONArray jsonArr = json.getString('event_array');

 for (int i = 0; i <= jsonArr.length(); i++) {
    JSONObject jsonEventData = jsonArr.getJsonObject(i);
 }