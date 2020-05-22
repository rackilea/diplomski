public class DeserializerJson implements JsonDeserializer<MyResponse> {

    @Override
    public MyResponse deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException {
        JsonObject content = je.getAsJsonObject();
        MyResponse message = new Gson().fromJson(je, type);
        JsonElement data = content.get("data");
        message.setData(new Gson().fromJson(data, message.getDataType().getType()));
        return message;

    }
}