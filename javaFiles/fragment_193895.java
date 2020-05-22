String whole = "Dr Smith.";
String part = "th.";
Matcher matcher = Pattern.compile(String.format("(?=\\S*?\\Q%s\\E)\\S+", part)).matcher(whole);

while (matcher.find()) {
    System.out.println(matcher.group());
}