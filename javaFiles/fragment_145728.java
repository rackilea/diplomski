public static Gson createGson() {
    return new GsonBuilder().registerTypeAdapter(Map.class, new NullSerializingMapSerializer()).create();
}

public class NullSerializingMapSerializer implements JsonSerializer<Map> {
    private static final Gson gson = (new GsonBuilder()).serializeNulls().create();
    public JsonElement serialize(Map map, Type typeOfSrc, JsonSerializationContext context) {
        if(map == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonPrimitive(gson.toJson(map));
    }
}