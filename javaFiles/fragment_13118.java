// Class
private static final Pattern pattern = Pattern.compile("^([A-Za-z]+|\\d+).*$");

// Your method
{
    String myString = "aBc123afa5";
    Matcher matcher = pattern.matcher(myString);
    if(matcher.matches())
        System.out.println(matcher.group(1));
}