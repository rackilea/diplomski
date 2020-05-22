final class ReadJsonStreamIntoListTest
        extends AbstractJsonStreamTest {

    private static final ITest instance = new ReadJsonStreamIntoListTest();

    private ReadJsonStreamIntoListTest() {
    }

    static ITest get() {
        return instance;
    }

    @Nonnull
    @Override
    public Collection<City> test(@Nonnull final JsonReader jsonReader)
            throws IOException {
        final List<City> cities = new ArrayList<>();
        read(jsonReader, cities::add);
        cities.sort(City::compareByName);
        return cities;
    }

}