final class FalseAsNullTypeAdapterFactory
        implements TypeAdapterFactory {

    // Let Gson instantiate it itself
    private FalseAsNullTypeAdapterFactory() {
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Get a downstream parser (for simplicity: get the default parser for the given type)
        final TypeAdapter<T> delegateTypeAdapter = gson.getDelegateAdapter(this, typeToken);
        return new TypeAdapter<T>() {
            @Override
            public void write(final JsonWriter out, final T value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public T read(final JsonReader in)
                    throws IOException {
                // Peek whether the next JSON token is a boolean
                if ( in.peek() == BOOLEAN ) {
                    // And take the this JSON token as a boolean value
                    // Is it true?
                    if ( in.nextBoolean() ) {
                        // Then it's not something we can handle -- probably a boolean field annotated with @JsonAdapter(FalseAsNullTypeAdapterFactory.class)?
                        throw new MalformedJsonException("Unexpected boolean marker: true");
                    }
                    // We're assuming it's null
                    return null;
                }
                // If it's not a boolean value, then we just delegate parsing to the original type adapter
                return delegateTypeAdapter.read(in);
            }
        };
    }

}