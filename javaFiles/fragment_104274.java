List<Object> deserialize(String className, String jsonString){  
    JsonParser parser = new JsonParser();
    JsonArray jsonArray = (JsonArray) parser.parse(jsonString);
    Iterator<JsonElement> iterator = jsonArray.iterator();
    List<Object> list = new ArrayList<>();
    while (iterator.hasNext()) {
        list.add(gson.fromJson(iterator.next(), className));
    }
    return list;
}