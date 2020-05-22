class RSDeserializer implements JsonDeserializer<List<RateInfo>> {
    @Override
    public List<RateInfo> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json instanceof JsonArray) {
            return Arrays.asList(context.deserialize(json, RateInfo[].class));
        }
        return Collections.singletonList(context.deserialize(json, RateInfo.class));
    }
}