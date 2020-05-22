String pattern = "([a-z]+)@([a-z]+)\\.([a-z]{3})";
String email = "user@email.com";
Matcher matcher = Pattern.compile(pattern).matcher(email);
// Check if there is a match, and then print the groups.
if (matcher.matches())
{
    // group(0) contains the entire string that matched the pattern.
    for (int i = 1; i <= matcher.groupCount(); i++)
    {
        System.out.println(matcher.group(i));
    }
}