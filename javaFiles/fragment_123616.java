public static final String PHONE_NO_PREFIX = getCountryCode();
private static String getCountryCode() {
    try {
        return CountryBO.getMobileCode();
    } catch (Exception e) {
        // TODO Handle the exception here
    }
}