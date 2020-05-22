// This is just a marker not meant to be instantiated but to create a sort of "gateway" to dispatch types in Gson
@SuppressWarnings("unused")
private static final class LenientListMarker<T> {
    private LenientListMarker() {
        throw new AssertionError("must not be instantiated");
    }
}

private static void doDeserialize()
        throws IOException {
    final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new TypeAdapterFactory() {
                @Override
                public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
                    // Check if the given type is the lenient list marker class
                    if ( !LenientListMarker.class.isAssignableFrom(typeToken.getRawType()) ) {
                        // Not the case? Just delegate the job to Gson
                        return null;
                    }
                    final Type listElementType = getTypeParameter0(typeToken.getType());
                    final TypeAdapter<?> listElementAdapter = gson.getAdapter(TypeToken.get(listElementType));
                    @SuppressWarnings("unchecked")
                    final TypeToken<List<?>> listTypeToken = (TypeToken<List<?>>) TypeToken.getParameterized(List.class, listElementType);
                    final TypeAdapter<List<?>> listAdapter = gson.getAdapter(listTypeToken);
                    final TypeAdapter<List<?>> typeAdapter = new TypeAdapter<List<?>>() {
                        @Override
                        public void write(final JsonWriter out, final List<?> value)
                                throws IOException {
                            // Always write a well-formed list
                            listAdapter.write(out, value);
                        }

                        @Override
                        public List<?> read(final JsonReader in)
                                throws IOException {
                            // Delegate the job to the reading method - we only have to tell how to obtain the list values
                            return parseToListLenient(in, listElementAdapter::read);
                        }
                    };
                    @SuppressWarnings("unchecked")
                    final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) typeAdapter;
                    return castTypeAdapter;
                }

                // A simple method to resolve actual type parameter
                private Type getTypeParameter0(final Type type) {
                    if ( !(type instanceof ParameterizedType) ) {
                        // List or List<?>
                        return Object.class;
                    }
                    return ((ParameterizedType) type).getActualTypeArguments()[0];
                }
            })
            .create();
    // This type declares a marker specialization to be used during deserialization
    final Type type = new TypeToken<LenientListMarker<Map<String, Integer>>>() {
    }.getType();
    try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q43528208.class, "non-standard.json") ) {
        // This is where we're a sort of cheating:
        // We tell Gson to deserialize LenientListMarker<Map<String, Integer>> but the type adapter above will return a list
        final List<Map<String, Integer>> maps = gson.fromJson(jsonReader, type);
        System.out.println(maps);
    }
}