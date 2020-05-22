// Note that TypeToken.getType() results can be considered value types thus being immutable and cached to a static final field
private static final Type researchesListType = new TypeToken<List<Research>>() {
}.getType();

// Gson is thread-safe as well, and can be used once per application
// Also, re-creating Gson instances would take more time due to its internals
private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(getResearchEffectTypeAdapterFactory())
        .create();

public static void main(final String... args)
        throws IOException {
    try ( final Reader reader = getPackageResourceReader(Q43643447.class, "doc.json") ) {
        final List<Research> researches = gson.fromJson(reader, researchesListType);
        researches.forEach(research -> System.out.println(research.name + " " + research.effect.getValue()));
    }
}