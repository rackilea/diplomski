JsonObject jsonObject = (JsonObject)new JsonParser().parse(input);
    JsonArray groupObject = jsonObject.getAsJsonArray("group");

    int countItem=0;
    for(int i=0;i<groupObject.size();i++) {
        JsonObject items = ((JsonObject)groupObject.get(i)).getAsJsonObject("item");
        countItem+=items.size();
    }