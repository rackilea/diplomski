public final class EmptyStringAsNullTypeAdapter<T>
        implements JsonDeserializer<T> {

    // Let Gson instantiate it itself
    private EmptyStringAsNullTypeAdapter() {
    }

    @Override
    public T deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        if ( jsonElement.isJsonPrimitive() ) {
            final JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if ( jsonPrimitive.isString() && jsonPrimitive.getAsString().isEmpty() ) {
                return null;
            }
        }
        return context.deserialize(jsonElement, type);
    }

}