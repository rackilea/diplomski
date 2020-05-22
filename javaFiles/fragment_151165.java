String filterToRegexExpression(String filter) {
    String regexExpression = filter
        .replace('?', '.')
        .replace("*", "(.*)");
    return "^" + regexExpression + "$"; // anchor or not at either end, as desired
}