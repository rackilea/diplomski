interface ITest {

    @Nonnull
    default String getName() {
        return getClass().getSimpleName();
    }

    @Nonnull
    Collection<City> test(@Nonnull JsonReader jsonReader)
            throws IOException;

}