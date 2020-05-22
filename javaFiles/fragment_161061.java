final class FromString
        implements TypeAdapterFactory {

    // Gson can instantiate it itself   
    private FromString() {
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Obtaining the original type adapter for the declared field
        return new FromStringTypeAdapter<>(gson.getAdapter(typeToken)).nullSafe();
    }

    private static final class FromStringTypeAdapter<T>
            extends TypeAdapter<T> {

        private final TypeAdapter<T> typeAdapter;

        private FromStringTypeAdapter(final TypeAdapter<T> typeAdapter) {
            this.typeAdapter = typeAdapter;
        }

        @Override
        public void write(final JsonWriter out, final T value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            // Just read the current value as a string, and delegate the job to the obtained type adapter
            final String innerJson = in.nextString();
            return typeAdapter.fromJson(innerJson);
        }

    }

}