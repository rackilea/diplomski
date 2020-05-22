public class Test {

    private static String REGEX_PATTERN = "[0-9]{1,}[,][0-9]{1,}";
    private static Pattern regExPattern = Pattern.compile(REGEX_PATTERN);
    private static Matcher regExMatcher;

    public static void main(String[] args) {
        test("1,3");  // true
        test("123");  // false
        test("1-3");  // false
        test("123,456");  // true
        test("123, 56");  // false
        test(" 23,456");  // false
        test("123,456\n");  // false
    }

    private static void test(String string) {
        regExMatcher = regExPattern.matcher(string);
        boolean isValid = regExMatcher.matches();
        System.out.printf("\"%s\" - %s%n", string, isValid);
    }
}