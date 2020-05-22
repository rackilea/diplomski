public static class DataDeserilizer implements JsonDeserializer {
    @Override
    public Data deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        Data data = gson.fromJson(json, Data.class);
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.has("meta")) {
            JsonElement elem = jsonObject.get("meta");
            if (elem != null && !elem.isJsonNull()) {

                Gson gsonDeserializer = new GsonBuilder()
                        .registerTypeAdapter(MetaData.class, new CustomDeserilizer())
                        .create();
                gsonDeserializer.fromJson(jsonObject.get("meta"), Data.class);
            }
        }

        return data;
    }



}