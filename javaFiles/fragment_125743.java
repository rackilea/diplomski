JSONObject json = new JSONObject(yourJsonString);
//This object will have String names inside, so "2", "3", "start" etc.
JSONArray names = json.names();
for(int i = 0; i < names.length(); i++) {
    JSONObject data = json.getJSONObject(names.getString(i));
    // Inside this data variable you will have the object.
    // You can check which name it has and react accordingly
}