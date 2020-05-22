final class VoidTypeAdapter
        extends TypeAdapter<Void> {

    private static final TypeAdapter<Void> voidTypeAdapter = new VoidTypeAdapter();

    private VoidTypeAdapter() {
    }

    static TypeAdapter<Void> getVoidTypeAdapter() {
        return voidTypeAdapter;
    }

    @Override
    @SuppressWarnings("resource")
    public void write(final JsonWriter out, final Void value)
            throws IOException {
        out.nullValue();
    }

    @Override
    public Void read(final JsonReader in)
            throws IOException {
        // Skip the current JSON tokens stream value entirely
        in.skipValue();
        return null;
    }

}