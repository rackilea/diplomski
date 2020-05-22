@Override
public User deserialize(JsonElement json, Type type,
        JsonDeserializationContext context) throws JsonParseException {

    JsonObject jobject = json.getAsJsonObject();

    return new User(
            jobject.get("id").getAsInt(), 
            jobject.get("name").getAsString(), 
            new Timestamp(jobject.get("update_date").getAsLong()));
}