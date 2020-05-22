String test = "sip:+8610086@dmcw.com";
String test2 = "8610086@dmcw.com";
Pattern pattern = Pattern.compile("(.+?:)?(.+?)(?=@)");
Matcher matcher = pattern.matcher(test);
if (matcher.find()) {
    System.out.println(matcher.group(2));
}
matcher = pattern.matcher(test2);
if (matcher.find()) {
    System.out.println(matcher.group(2));
}