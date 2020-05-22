final class NoKeysTypeAdapter<E>
        extends TypeAdapter<List<E>> {

    private final Gson gson;
    private final Type elementType;

    private NoKeysTypeAdapter(final Gson gson, final Type elementType) {
        this.gson = gson;
        this.elementType = elementType;
    }

    static <E> TypeAdapter<List<E>> getNoKeysTypeAdapter(final Gson gson, final Type elementType) {
        return new NoKeysTypeAdapter<>(gson, elementType);
    }

    @Override
    public void write(final JsonWriter out, final List<E> value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> read(final JsonReader in)
            throws IOException {
        final List<E> list = new ArrayList<>();
        // Make sure that the next JSON stream token is `{`
        in.beginObject();
        // Read until the object ends
        while ( in.peek() != END_OBJECT ) {
            // Ignore the found JSON object property name
            in.nextName();
            // And delegate the property value parsing to a downstream parser
            final E element = gson.fromJson(in, elementType);
            list.add(element);
        }
        // Make sure that the JSON stream is finished with the `}` token
        in.endObject();
        return list;
    }

}