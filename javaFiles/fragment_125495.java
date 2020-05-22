Matcher callMatcher = callPattern.matcher(test);

while (callMatcher.find()) {
    test = callMatcher.replaceFirst(generate());
    callMatcher = callPattern.matcher(test); // updates the matcher with replaced text
}