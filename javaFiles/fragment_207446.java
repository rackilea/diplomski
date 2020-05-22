pattern = Pattern.compile("\\{((\\w+)Start)\\}(.*?)\\{(\\2End)\\}");
Matcher matcher = pattern.matches(input);

while (matcher.find()) {
    // matcher.start(1) matcher.end(1) matcher.group(1) return index of start of opening tag, its end and content
    // similarly for end tag - start(4) etc.
    // similarly for tag content - start(3) etc.
    // group(2) returns just the tag name
    String result = matcher.group(3);
    // do something with result
}