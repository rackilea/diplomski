final class FirstTest
        implements ITest {

    private static final ITest instance = new FirstTest();

    private FirstTest() {
    }

    static ITest get() {
        return instance;
    }

    @Nonnull
    @Override
    public List<City> test(@Nonnull final JsonReader jsonReader)
            throws IOException {
        jsonReader.beginArray();
        final List<City> cities = new ArrayList<>();
        while ( jsonReader.hasNext() ) {
            final City city = new Gson().fromJson(jsonReader, City.class);
            cities.add(city);
        }
        jsonReader.endArray();
        cities.sort(City::compareByName);
        return cities;
    }

}