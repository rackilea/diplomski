final String regex = "\\[[^\\[]*\\]";
final String string = "Test[Test1][Test2]Test3\n";
final String subst = "";
final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);
final String result = matcher.replaceAll(subst);
System.out.println(result);