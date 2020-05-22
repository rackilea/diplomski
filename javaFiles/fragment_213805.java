public class CountryDao {
    private static final Model.Finder<String, Country> FIND = new Model.Finder<>(String.class, Country.class);

    // not static if you don't want it to be
    public List<Country> findAll() {
        return FIND.all();
    }
}