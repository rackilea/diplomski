String string = "/this/(?<capture1>.*)/a/string/(?<capture2>.*)";
Pattern pattern = Pattern.compile(string);
Matcher matcher = pattern.matches(string);

string.replace(matcher.group("capture1"), "value 1");
string.replace(matcher.group("capture2"), "value 2");