private static Gson createCustomGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(String.class, new JsonDeserializer<String>() {
        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return (json.getAsString().equals("nil")) ? null : json.getAsString();
        }
    });
    gsonBuilder.registerTypeAdapter(KeywordListing.class, new JsonDeserializer< KeywordListing >() {
                @Override
                public KeywordListing deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
                    return new Gson().fromJson(json, KeywordListing.class);
                }
            });

    return gsonBuilder.create();
}