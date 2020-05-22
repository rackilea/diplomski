public class ClassYouAreConvertingTo {
    private static final String NETHERLANDS = "NLD";
    private static final String UNKNOWN = "???";

    @StringDef({NETHERLANDS, UNKNOWN})
    @Retention(RetentionPolicy.SOURCE)
    private @interface CountryCode {}

    private String countryCode;

    @CountryCode
    public String getCountryCode() {
        return this.countryCode;
    }
}