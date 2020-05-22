Pattern regex = Pattern.compile(
    "(?:                             # Start of group:\n" +
    " \\b                            # Match start of a word\n" +
    " (?:                            # Start of inner group:\n" +
    "  [A-Z][a-z]*                   # Either match an uppercase word\n" +
    " |                              # or\n" +
    "  (?:a[nts]|the|by|for|i[nt]|   # one of these 'special' words\n" +
    "     o[fnr]|to|up|and|but|nor)                                \n" +
    " )                              # End of inner group\n" +
    " \\b                            # Match end of word\n" +
    " \\s+                           # Match one or more whitespace characters\n" +
    ")+                              # Match one or more of the above.", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subject);
if (regexMatcher.find()) {
    ResultString = regexMatcher.group();
}