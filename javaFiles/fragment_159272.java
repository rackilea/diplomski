String testString = "111000001010000100001111";

Pattern pattern = Pattern.compile("1+|0+");
Matcher matcher = pattern.matcher(testString);

while (matcher.find())
{
    System.out.print(matcher.group().length());
    System.out.print(" ");
}