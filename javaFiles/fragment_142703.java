List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "hello # Match 'hello'\n" +
    ".*?   # Match 0 or more characters (any characters), as few as possible\n" +
    "world # Match 'world'", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}