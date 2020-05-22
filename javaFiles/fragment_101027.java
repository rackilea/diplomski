private static final String PATTERN_TO_FIND = "[aeiousrtmvb257]";

public static void main(String[] args) {
    System.out.println(searchForSignature2("111aeiousrtmvb257111"));
}

public static String searchForSignature2(String texto2) {
    Pattern pattern = Pattern.compile(PATTERN_TO_FIND);
    Matcher matcher = pattern.matcher(texto2);

    StringBuilder result = new StringBuilder();

    while (matcher.find()) {
        result.append(matcher.group());
    }

    return result.toString();
}