private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(StrictEnumTypeAdapterFactory.get())
        .create();

public static void main(final String... args)
        throws IOException {
    try ( final JsonReader jsonReader = Resources.getPackageResourceJsonReader(Q49572505.class, "good.json") ) {
        System.out.println(gson.<Status>fromJson(jsonReader, Status.class).access);
    }
    try ( final JsonReader jsonReader = Resources.getPackageResourceJsonReader(Q49572505.class, "bad.json") ) {
        try {
            gson.<Status>fromJson(jsonReader, Status.class);
            throw new AssertionError();
        } catch ( final JsonParseException ex ) {
            System.out.println(ex.getMessage());
        }
    }
}