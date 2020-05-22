JsonObject data = new Gson().fromJson(jsonString, JsonObject.class);
    JsonArray names = data .get("items").getAsJsonArray();
    for(JsonElement element : names){
        JsonObject object = element.getAsJsonObject();
        System.out.println(object.get("metadata").getAsJsonObject().get("name").getAsString());
    }