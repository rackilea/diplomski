public class Test {
    private static final String DEFAULT_VALUE = "firstReallyLongDefaultString";
    private final String stringParameter;

    public Test() {
        this(DEFAULT_VALUE);
    }

    public Test(String s) {
        stringParameter = s;
    }

    public Test(char c) {
        this(prepareString(c));
    }

    private static String prepareString(char c) {
        if(Character.isLetter(s)) {
            return "firstReallyLong" + s + "DefaultString";
        } else {
            return DEFAULT_VALUE;
        }
    }

}