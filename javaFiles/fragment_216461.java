class CustomDeserializer implements JsonDeserializer<Response> {

    @Override
    public Response deserialize(JsonElement jsonElement, Type typeOfElement, JsonDeserializationContext context) throws JsonParseException {
        JsonObject data = jsonElement.getAsJsonObject().get("response").getAsJsonObject().get("data").getAsJsonObject();
        Type listType = new TypeToken<List<Data>>() {}.getType();
        Map<String, List<Data>> dataMap = new HashMap<String, List<Data>>();

        for (Map.Entry<String, JsonElement> entry : data.entrySet()) {
            List<Data> dataList = context.deserialize(entry.getValue(), listType);

            dataMap.put(entry.getKey(), dataList);
        }

        return new Response(dataMap);
    }
}