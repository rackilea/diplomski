public final class Serializer {
    private static Moshi moshi = new Moshi.Builder().build();

    public static <T> T parse(String json, Class<T> objClass) throws IOException {
        JsonAdapter<T> adapter = moshi.adapter(objClass); 
        return adapter.fromJson(json);
    }

    @NonNull
    public static <T> String stringify(T obj, Class<T> objClass) {
        JsonAdapter<T> adapter = moshi.adapter(objClass); 
        return adapter.toJson(obj);
    }
}