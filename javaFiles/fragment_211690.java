final class PackedJsonStreamTypeAdapter
        extends TypeAdapter<String> {

    private PackedJsonStreamTypeAdapter() {
    }

    @Override
    public void write(final JsonWriter out, final String json)
            throws IOException {
        @SuppressWarnings("resource")
        final Reader reader = new StringReader(json);
        writeNormalizedJsonStream(new JsonReader(reader), out);
    }

    @Override
    public String read(final JsonReader in)
            throws IOException {
        @SuppressWarnings("resource")
        final Writer writer = new StringWriter();
        writeNormalizedJsonStream(in, new JsonWriter(writer));
        return writer.toString();
    }

}