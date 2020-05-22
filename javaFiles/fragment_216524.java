public static void main(String[] args) {
    extractValuesFromRegex("(?:0+|)(\\d+)", "00123");
    extractValuesFromRegex("(?:0+|)(\\d+)", "123");
    extractValuesFromRegex("(\\d+)", "00123");
    extractValuesFromRegex("(\\d+)", "00123");
}

public static final String extractValuesFromRegex(String regex, String input) {
    String extractevalue = input;
    Matcher matcher = Pattern.compile(regex).matcher(input);

    if (matcher.matches()) {
        extractevalue = matcher.group(1);
    }
    return extractevalue;
}