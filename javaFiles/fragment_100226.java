String text = "@martin I will come and meet you at the woods 123@martin @ martin";

String patternString = "(^|\\W)(@\\w+?)(\\W|$)";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
    System.out.println(matcher.group(2));
}