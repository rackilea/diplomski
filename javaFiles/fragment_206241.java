final class ReadJsonStreamIntoTreeSetTest
        extends AbstractJsonStreamTest {

    private static final ITest instance = new ReadJsonStreamIntoTreeSetTest();

    private ReadJsonStreamIntoTreeSetTest() {
    }

    static ITest get() {
        return instance;
    }

    @Nonnull
    @Override
    public Collection<City> test(@Nonnull final JsonReader jsonReader)
            throws IOException {
        final Collection<City> cities = new TreeSet<>(City::compareByName);
        read(jsonReader, cities::add);
        return cities;
    }

}