...
public static String PHONE_NO_PREFIX;

static {
    try {
        PHONE_NO_PREFIX = CountryBO.getMobileCode();
    } catch (Exception e) {
        // TODO Handle the exception here
    }
}