class LowercaseMapTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        TypeAdapter<String> stringAdapter = gson.getAdapter(TypeToken.get(String.class));

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) { }

            @Override
            public T read(JsonReader in) throws IOException {
                JsonToken peek = in.peek();
                if (peek == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }

                Map<String, String> map = new HashMap<>();

                in.beginObject();
                while (in.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(in);
                    String key = stringAdapter.read(in).toLowerCase();
                    String value = stringAdapter.read(in);
                    String replaced = map.put(key, value);
                    if (replaced != null) {
                        throw new JsonSyntaxException("duplicate key: " + key);
                    }
                }
                in.endObject();

                return (T) map;
            }
        };
    }
}