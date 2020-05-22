//assumes a Matcher matcher which has already matched the text with .find() or .matches()
int groupCount = 3;  // for more complex cases, use matcher.groupCount();
String[] parts = new String[groupCount];
for (int groupIndex = 0; groupIndex < groupCount; groupIndex++) {
    parts[groupIndex] = matcher.group(groupIndex);
}