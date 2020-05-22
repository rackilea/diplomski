final class ReadAsWholeTreeSetTest
        implements ITest {

    private static final ITest instance = new ReadAsWholeTreeSetTest();

    private ReadAsWholeTreeSetTest() {
    }

    static ITest get() {
        return instance;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final TypeToken<TreeSet<?>> rawTreeSetType = (TypeToken) TypeToken.get(TreeSet.class);

    private static final Map<Type, Comparator<?>> comparatorsRegistry = ImmutableMap.of(
            City.class, (Comparator<City>) City::compareByName
    );

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new TypeAdapterFactory() {
                @Override
                public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
                    if ( !TreeSet.class.isAssignableFrom(typeToken.getRawType()) ) {
                        return null;
                    }
                    final Type elementType = ((ParameterizedType) typeToken.getType()).getActualTypeArguments()[0];
                    @SuppressWarnings({ "rawtypes", "unchecked" })
                    final Comparator<Object> comparator = (Comparator) comparatorsRegistry.get(elementType);
                    if ( comparator == null ) {
                        return null;
                    }
                    final TypeAdapter<TreeSet<?>> originalTreeSetTypeAdapter = gson.getDelegateAdapter(this, rawTreeSetType);
                    final TypeAdapter<?> originalElementTypeAdapter = gson.getDelegateAdapter(this, TypeToken.get(elementType));
                    final TypeAdapter<TreeSet<Object>> treeSetTypeAdapter = new TypeAdapter<TreeSet<Object>>() {
                        @Override
                        public void write(final JsonWriter jsonWriter, final TreeSet<Object> treeSet)
                                throws IOException {
                            originalTreeSetTypeAdapter.write(jsonWriter, treeSet);
                        }

                        @Override
                        public TreeSet<Object> read(final JsonReader jsonReader)
                                throws IOException {
                            jsonReader.beginArray();
                            final TreeSet<Object> elements = new TreeSet<>(comparator);
                            while ( jsonReader.hasNext() ) {
                                final Object element = originalElementTypeAdapter.read(jsonReader);
                                elements.add(element);
                            }
                            return elements;
                        }
                    }.nullSafe();
                    @SuppressWarnings({ "rawtypes", "unchecked" })
                    final TypeAdapter<T> castTreeSetTypeAdapter = (TypeAdapter<T>) treeSetTypeAdapter;
                    return castTreeSetTypeAdapter;
                }
            })
            .create();

    private static final Type citiesSetType = new TypeToken<TreeSet<City>>() {
    }.getType();

    @Nonnull
    @Override
    public Set<City> test(@Nonnull final JsonReader jsonReader) {
        return gson.fromJson(jsonReader, citiesSetType);
    }

}