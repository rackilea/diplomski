JSONArray agent = jsonObject.getJsonArray("agent");

// To get the actual values, you can do this:
for(int i = 0; i < agent.size(); i++) {
    JSONObject object = agent.get(i);
    String value1 = object.get("name");
    String value2 = object.get("value");
}