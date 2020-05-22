public class LabelsDeserializer extends TypeAdapter<List<String>> {
    @Override
    public void write(
            final JsonWriter out,
            final List<String> labels) throws IOException {
        if (labels.size() == 1) {
            out.value(labels.get(0));
            return;
        }

        out.beginArray();

        for (final String l : labels) {
            out.value(l);
        }

        out.endArray();
    }

    @Override
    public List<String> read(final JsonReader in) throws IOException {
        final JsonToken peek = in.peek();

        if (peek.equals(JsonToken.BEGIN_ARRAY)) {
            final List<String> labels = new ArrayList<>();
            in.beginArray();

            while (in.hasNext()) {
                labels.add(in.nextString());
            }

            in.endArray();
            return labels;
        }

        return Collections.singletonList(in.nextString());
    }
}