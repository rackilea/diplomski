GsonBuilder builder = new GsonBuilder();

builder.registerTypeAdapter(Timestamp.class, new JsonDeserializer<Timestamp>() {

@Override
public Timestamp deserialize(JsonElement json, Type type, JsonDeserializationContext deserializationContext) throws JsonParseException {
    return new Timestamp(json.getAsJsonPrimitive().getAsLong());
    }
});

Gson gson = builder.create();
CoaAccountList transHisList = gson.fromJson(jsonString, CoaAccountList.class);