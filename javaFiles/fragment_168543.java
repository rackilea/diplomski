Pattern pattern = Pattern.compile("UTC([+\-]\d):\d\d");
Matcher tagMatch = pattern.matcher(sourceString);
while (tagMatch.find()) {
    String parsed = parseTag(tagMatch.group(1);
    TimeZone t= TimeZone.getTimeZone(String.format("Etc/GMT%s", parsed));
}