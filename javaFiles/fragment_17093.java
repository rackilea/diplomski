try {
    Pattern regex = Pattern.compile("\\G\\[(?:(?:name:(?<name>[^,\\]]+)|quantity:(?<quantity>[^,\\]]+)|unit_price:(?<unit_price>[^,\\]]+)),?)*\\](?:,|\\z)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.DOTALL);
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        // matched text for "name": regexMatcher.group("name")
        // matched text for "quantity": regexMatcher.group("quantity")
        // matched text for "unit_price": regexMatcher.group("unit_price")
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}