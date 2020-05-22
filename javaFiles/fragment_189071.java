Gson gson = new Gson();

//Type type = new TypeToken<Map<String, UsersPOJO>>(){}.getType();
//Map<String, UsersPOJO> myUsers = gson.fromJson(jsonString, type);

JsonParser parser = new JsonParser();
JsonElement topElement = parser.parse(jsonString);
Map<String, UsersPOJO> myUsers = new HashMap<>();
for (Map.Entry<String, JsonElement> entry : topElement.getAsJsonObject().entrySet()) {
    if (entry.getValue().isJsonArray()) {
        //skip or process array
    } else {
        myUsers.put(entry.getKey(), gson.fromJson(entry.getValue(), UsersPOJO.class));
    }
}