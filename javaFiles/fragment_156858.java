String mydata = "some '' string with 'hello' inside 'and inside'";
Pattern pattern = Pattern.compile("'[^']*'");
Matcher matcher = pattern.matcher(mydata);
while(matcher.find())
{
    System.out.println(matcher.group());
}