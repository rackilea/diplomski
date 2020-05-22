public JsonDeserializer<Key> keyDs = new JsonDeserializer<Key>() {
    private final Gson gson = new Gson(); 
    @Override
    public Key deserialize(JsonElement json, Type typeOfT,
                               JsonDeserializationContext context)
            throws JsonParseException {
        // This will be valid JSON
        String keyJson = json.getAsString();
        // use another Gson to parse it, 
        // otherwise you will have infinite recursion
        Key key = gson.fromJson(keyJson, Key.class);
        return key;
    }
};