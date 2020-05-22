String pattern = ";(?<foo>\\d{6});(?<bar>\\d{6});";
Pattern regex = Pattern.compile(pattern);
Matcher matcher = regex.matcher(";123456;123456;");
boolean success = matcher.find();

String foo = success ? matcher.group("foo") : null;
String bar = success ? matcher.group("bar") : null;