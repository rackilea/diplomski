Pattern regex = Pattern.compile("\\b(TWO|FOUR|SEVEN)=([^ ]*)\\b");
Matcher regexMatcher = regex.matcher(yourString);
if (regexMatcher.find()) {
    String theMatch = regexMatcher.group();
    String FoundToken =  = regexMatcher.group(1);
    String EndPosition = regexMatcher.end();
}