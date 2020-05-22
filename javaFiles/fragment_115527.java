String ResultString = null;
try {
    Pattern regex = Pattern.compile("=== FIRST KEYWORD ===[^{]*?(\\{\\{(?:.(?!}}))*.}})", Pattern.DOTALL);
    Matcher regexMatcher = regex.matcher(subjectString);
    if (regexMatcher.find()) {
        ResultString = regexMatcher.group(1);
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}