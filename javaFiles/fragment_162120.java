StringBuilder stringBuilder = new StringBuilder(text);
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(stringBuilder);
int start = 0;
while (matcher.find(start)) {
    stringBuilder.append(stringBuilder, matcher.start(), matcher.end());
    start = matcher.end();
    matcher.reset();
}
text = stringBuilder.toString();