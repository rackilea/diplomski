Pattern regex = Pattern.compile("(?<=\\])[^\\[\\]\"]+(?=\\.)");
Matcher regexMatcher = regex.matcher(yourString);
if (regexMatcher.find()) {
    String theFirstMatch: regexMatcher.group()
} 
if (regexMatcher.find()) {
    String theSecondMatch: regexMatcher.group()
}