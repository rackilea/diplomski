Pattern regex = Pattern.compile(
    "[+-]?           # Match a number, starting with an optional sign,\n" +
    "\\d+            # a mandatory integer part,\n" +
    "(?:\\.\\d+)?    # optionally followed by a decimal part\n" +
    "(?:e[+-]?\\d+)? # and/or an exponential part.\n" +
    "|               # OR\n" +
    "(?:             # Match...\n" +
    " (?![+-]?\\d)   # (unless it's the beginning of a number)\n" +
    " .              # any character\n" +
    ")*              # any number of times.", 
    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}