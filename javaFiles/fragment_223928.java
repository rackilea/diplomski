Pattern pattern = Pattern.compile("(\\d+\\.[0-9]{2})");

Matcher matcher = pattern.matcher(thirdColumn);

while(matcher.find())
{
    System.out.println(matcher.group());
}