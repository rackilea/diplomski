List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "([\\p{Lu}_]+)  # one or more characters, all caps and underscores\n" +
    "\\s*=\\s*      # equals sign, possibly surrounded by whitespace\n" +
    "([^=]+)        # any letters except equals sign\n" +
    "(?<=\\p{Ll})   # but only until the last lowercase letter", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}