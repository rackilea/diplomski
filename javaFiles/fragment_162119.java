Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);
int start = 0;
while (matcher.find(start)) {
    text = text + text.substring(matcher.start(), matcher.end());
    start = matcher.end();
    matcher = pattern.matcher(text);
}