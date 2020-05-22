final JSONObject jsonObject = new JSONObject(json);
final JSONArray a = (JSONArray) jsonObject.get("a");
final List<String> returnArray = new ArrayList<>();

for (int i = 0; i < a.length(); i++) {
    returnArray.add((String)a.get(i));
}

return returnArray;