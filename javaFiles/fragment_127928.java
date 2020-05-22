@SuppressWarnings("resource")
public static void main(final String... args)
        throws IOException {
    final JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(System.out));
    jsonWriter.setIndent("  ");
    jsonWriter.beginArray();
    jsonWriter.beginObject();
    jsonWriter.name("New").value("Tester");
    jsonWriter.name("B").value("Tester");
    jsonWriter.name("A").value("Tester");
    jsonWriter.name("Test").value("Tester");
    jsonWriter.endObject();
    jsonWriter.endArray();
    jsonWriter.flush();
}