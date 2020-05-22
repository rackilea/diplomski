public interface CountryCodes {

    public static enum Country {
        FRANCE("FR"),
        GERMANY("DE"),
        SPAIN("ES"),
        PORTUGAL("PT");

        private final String e_countryId;

        private Country(String c) {
            this.e_countryId = c;
        }
    }
    :
    :
}