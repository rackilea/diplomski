private static final Gson gson = new Gson();
private static final TypeAdapter<JsonElement> jsonElementTypeAdapter = gson.getAdapter(JsonElement.class);

public static void main(final String... args)
        throws IOException {
    try ( final Reader reader = getPackageResourceReader(Q43528208.class, "non-standard.json") ) {
        final JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true); // this makes it work
        while ( jsonReader.peek() != END_DOCUMENT ) {
            final JsonElement jsonElement = jsonElementTypeAdapter.read(jsonReader);
            System.out.println(jsonElement);
        }
    }
}