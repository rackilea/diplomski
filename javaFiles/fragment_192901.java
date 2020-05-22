List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "(?<!\\\\)   # Assert no preceding backslash\n" +
    "\\{         # Match a {\n" +
    "(foo|bar|nice|notgood|bad) # Match a keyword\n" +
    "\\}         # Match a }", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group(1));
}