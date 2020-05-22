final String text = "This is param-start ?abcdef; param-end";
final String patternString = "(['\"]?)\\?.*?;\\1";
final Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
final Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println("Match found: " + matcher.group());
}
// => Match found: = ?abcdef;