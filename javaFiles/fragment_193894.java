String whole = "foo foobar barfoo baz";
String part = "foo";

Matcher matcher = Pattern.compile("(?=\\S*?" + part + ")\\S+").matcher(whole);

while (matcher.find()) {
    System.out.println(matcher.group());
}