class OneOrManyJsonDeserializer implements JsonDeserializer<List<?>> {

    @Override
    public List<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final Type elementType = $Gson$Types.getCollectionElementType(typeOfT, List.class);

        if (json instanceof JsonArray) {
            final JsonArray array = (JsonArray) json;
            final int size = array.size();
            if (size == 0) {
                return Collections.emptyList();
            }

            final List<?> suites = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                suites.add(context.deserialize(array.get(i), elementType));
            }

            return suites;
        }

        Object suite = context.deserialize(json, elementType);
        return Collections.singletonList(suite);
    }
}