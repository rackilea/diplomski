private static final Pattern REGEX_PATTERN = 
        Pattern.compile("\\b(\\p{Digit}+)(\\p{Alpha})\\b");

public static void main(String[] args) {
    String input = "Hello world 65x";
    Matcher matcher = REGEX_PATTERN.matcher(input);
    while (matcher.find()) {
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }
}