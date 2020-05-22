Pattern termPattern = Pattern.compile("\\d+(?:\\.\\d+)?(x(?:\\^\\d+)?)?");
Matcher termMatcher = termPattern.matcher(input);
while (termMatcher.find()) {
    if (termMatcher.group(1) == null) {
        // you have a free term
    }
}