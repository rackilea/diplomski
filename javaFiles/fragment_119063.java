public class Program {  
    private static Object lock = new Object();
    private static final Pattern BIG_DECIMAL_MATCHER;

    static {
        synchronized (lock) {
            BIG_DECIMAL_MATCHER = Pattern.compile("-?(?:\\d+(?:\\.\\d+)?|\\.\\d+)"); 
            // credit to stackoverflow.com/questions/14343551
        }
    }

    /**
     * Attempts to force a given String value to a valid BigDecimal. If there are 
     * multiple valid BigDecimal values, only the first is returned.
     */
    static BigDecimal forceBigDecimal(String value) { 
        Matcher moneyMatcher = BIG_DECIMAL_MATCHER.matcher(value);

        while (moneyMatcher.find()) {
            return new BigDecimal(moneyMatcher.group());
        }
        throw new NumberFormatException(
            String.format("Valid number not found in value: %s", value));
    }
}