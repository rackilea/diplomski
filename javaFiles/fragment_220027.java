private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(JsonFailSafeTypeAdapterFactory.get())
        .create();

public static void main(final String... args)
        throws IOException {
    try ( final JsonReader jsonReader = Resources.getPackageResourceJsonReader(Q50002961.class, "farm.json") ) {
        final Farm oldMcdonald = gson.fromJson(jsonReader, Farm.class);
        if ( oldMcdonald.dog != null ) {
            throw new AssertionError();
        }
        System.out.println(oldMcdonald);
    }
}