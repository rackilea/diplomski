public class GenericGroupDeserializer implements JsonDeserializer<GenericGroup> {
    @Override
    public GenericGroup deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String type = json.getAsJsonObject().get("type").getAsString();
        switch (type){
            case "someType":
                return new Gson().fromJson(json.toString(), GenericGroup.SomeGroup.class);
            case "someOtherType":
                return new Gson().fromJson(json.toString(), GenericGroup.SomeOtherGroup.class);
            default:
                return new GenericGroup();
        }
    }
}