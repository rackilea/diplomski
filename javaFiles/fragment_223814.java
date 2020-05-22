String test = "John Doe";
String regex = test.replaceAll("\\s", "|");
Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

Matcher matcher = pattern.matcher("John");
System.out.println(matcher.find());
System.out.println(matcher.start());

matcher = pattern.matcher("xJohn");
System.out.println(matcher.find());
System.out.println(matcher.start());