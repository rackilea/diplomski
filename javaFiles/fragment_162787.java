List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "\"          # Match a quote\n" +
    "(           # Capture in group number 1:\n" +
    " (?:        # Match either...\n" +
    "  \\\\.     # an escaped character\n" +
    " |          # or\n" +
    "  [^\"\\\\] # any character except quotes or backslashes\n" +
    " )*         # Repeat as needed\n" +
    ")           # End of capturing group\n" +
    "\"          # Match a quote", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group(1));
}