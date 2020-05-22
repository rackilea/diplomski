enum RegularExpressionConstants {
    FOO_REG_EX("foo", alphanumericWithRange(1, 16)), 
    BAR_REG_EX("bar", alphanumericWithRange(2,4));

    private final String name;
    private final String pattern;

    private RegularExpression(String name, String pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public String getPattern() {
        return pattern;
    }

    private static String alphanumericWithRange(int lowerLimit, int upperLimit) {
        return "[a-zA-Z0-9]{" + lowerLimit + "," + upperLimit + "}";
    }
}