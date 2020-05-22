String s = "/something/users/myemail@email.com/somethingelse";         
Matcher m = Pattern.compile(EMAIL_REGEX).matcher(s);
while (m.find())
{
    System.out.println(m.group());
} // => myemail@email.com