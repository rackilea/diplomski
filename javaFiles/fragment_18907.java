Pattern findWordPattern = Pattern.compile("his");
Matcher matcher = findWordPattern.matcher(myWholeFileInAString);
while(matcher.find()) {
    int offsetStart = matcher.start();
    int offsetEnd = matcher.end();
    // do something with offsetStart and offsetEnd
}