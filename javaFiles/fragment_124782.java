public enum Country {
...
public static Country getCountry(int countryCode) {
    for(Country country : Country.values()) {
        if(country.code == countryCode) {
            return country;
        }
    }
    throw new IllegalArgumentException();
}