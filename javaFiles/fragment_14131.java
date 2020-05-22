String getPattern(String fromString) {
    Map<CharMatcher, String> charToRegex = Maps.newHashMap();
    charToRegex.put(CharMatcher.JAVA_LOWER_CASE, "[a-z]");
    charToRegex.put(CharMatcher.JAVA_UPPER_CASE, "[A-Z]");
    charToRegex.put(CharMatcher.WHITESPACE, "\\s");

    StringBuilder pattern = new StringBuilder();
    String lastRegexPart = "";

    for (int i = 0; i < fromString.length(); i++) {
        for (CharMatcher matcher : charToRegex.keySet()) {
            if (matcher.apply(fromString.charAt(i))) {
                String regexPart = charToRegex.get(matcher);
                if (lastRegexPart.equals(regexPart)) {
                    if (pattern.lastIndexOf("+") != pattern.length() - 1) {
                        pattern.append("+");
                    }
                } else {
                    pattern.append(regexPart);
                    lastRegexPart = regexPart;
                }
            }
        }
    }
    return pattern.toString();
}