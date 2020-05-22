final class ReadAsWholeListTest
        implements ITest {

    private static final ITest instance = new ReadAsWholeListTest();

    private ReadAsWholeListTest() {
    }

    static ITest get() {
        return instance;
    }

    private static final Gson gson = new Gson();

    private static final Type citiesListType = new TypeToken<List<City>>() {
    }.getType();

    @Nonnull
    @Override
    public List<City> test(@Nonnull final JsonReader jsonReader) {
        final List<City> cities = gson.fromJson(jsonReader, citiesListType);
        cities.sort(City::compareByName);
        return cities;
    }

}