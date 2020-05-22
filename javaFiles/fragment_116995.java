class ObjectsDeserializer implements JsonDeserializer<Objects> {
    @Override
    public Objects deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject().getAsJsonObject("Objects");
        List<NestedObject1> list = new ArrayList<>();
        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            List<NestedObject2> nestedObject2List = new ArrayList<>();
            //here deserialize each NestedObject2 and put it in the list
            list.add(new NestedObject1(entry.getKey(), nestedObject2List));
        }
        return new Objects(list);
    }
}