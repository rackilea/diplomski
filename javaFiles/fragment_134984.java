public class Country {

    private static Map<String, Country> countries = new HashMap<String, Country>();

    static {
        countries.put("Spain", new EuroCountry("Spain"));

    }

...