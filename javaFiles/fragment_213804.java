@Entity
public class Country extends Model {

    private static final Finder<String, Country> FIND = new Finder<>(String.class, Country.class);

    @Id
    public String iso2;

    public static List<Country> findAll() {
        return FIND.all();
    }

    // other stuff
}