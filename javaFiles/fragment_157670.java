String text = "24-15-7-49-63-2";
String pattern = "\\b([1-9]|1[0-8])\\b";

Pattern compiledPattern = Pattern.compile(pattern);
Matcher matcher = compiledPattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());
}