final class FalseAsNullTypeAdapterFactory
        implements TypeAdapterFactory {

    // No worries, Gson will instantiate it itself
    private FalseAsNullTypeAdapterFactory() {
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final TypeAdapter<T> delegateAdapter = gson.getAdapter(typeToken);
        return new TypeAdapter<T>() {
            @Override
            public void write(final JsonWriter out, final T value)
                    throws IOException {
                delegateAdapter.write(out, value);
            }

            @Override
            public T read(final JsonReader in)
                    throws IOException {
                // If the next token is a boolean
                if ( in.peek() == JsonToken.BOOLEAN ) {
                    // and it's true
                    if ( in.nextBoolean() ) {
                        // then just report an unexpected `true` literal
                        throw new MalformedJsonException("Expected a null value indicator as `false`. " + in);
                    }
                    // and it's false, then we assume it's a null
                    return null;
                }
                // Otherwise read the whole value as a usual
                return delegateAdapter.read(in);
            }
        };
    }

}