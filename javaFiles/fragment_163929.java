class OneOrManyJsonDeserializer<E> implements JsonDeserializer<List<E>> {

    private final Class<E> clazz;

    public OneOrManyJsonDeserializer(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<E> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json instanceof JsonArray) {
            final JsonArray array = (JsonArray) json;
            final int size = array.size();
            if (size == 0) {
                return Collections.emptyList();
            }
            final List<E> suites = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                suites.add(context.deserialize(array.get(i), clazz));
            }

            return suites;
        }

        E suite = context.deserialize(json, clazz);
        return Collections.singletonList(suite);
    }
}