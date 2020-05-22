String text = "46.102.241.199:3128 0.2990 Transp. NN N 100% 2011-11-19 17:56:02";
String pattern = "\\d{1,3}(?:\\.\\d{1,3}){3}(?::\\d{1,5})?";

Pattern compiledPattern = Pattern.compile(pattern);
Matcher matcher = compiledPattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());
}