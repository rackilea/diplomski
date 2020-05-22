String s1 = "!(AString&BString)|CString";
Matcher m = Pattern.compile("[^()!&|]+").matcher(s1);
while(m.find())
{

System.out.println(m.group() + "  => " + m.start() +  " to " + (m.end()-1));

}