private static final Pattern REGEX_PATTERN = 
        Pattern.compile("<[^>]*>([^<>]*)<[^>]*>");

public static void main(String[] args) {
    String input = "<City count='1' relevance='0.304' normalized='Shanghai,China'>Shanghai</City>";

    System.out.println(
        REGEX_PATTERN.matcher(input).replaceAll("$1")
    );  // prints "Shanghai"
}