final String s =
    "killing of <span class=\"abc\">cats</span>, "
    + "hi <span class=\"xyz\">dogs</span>,";
final Matcher matcher = Pattern.compile(
    "(<.*?>.*?</.*?>|\\w+)\\p{Punct}*").matcher(s);
while (matcher.find()) {
    System.out.println(matcher.group());
}