public class SqlValidator {

private static final String SINGLE_QUOTE    = "\u0027";

    /**
     * It replaces all ' with ''. It should be used in read/write queries.
     * 
     * @param str
     */
    public static String quoteInQuery(String str) {
    if (str == null)
        return null;
    return str.replaceAll(SINGLE_QUOTE, SINGLE_QUOTE + SINGLE_QUOTE);
    }
}