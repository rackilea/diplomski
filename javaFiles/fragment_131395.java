String s = "String txt = \"Map. 12. txt Map. 13. txt Map. 14 txt ";
Matcher m = Pattern.compile("(Map\\p{Punct}\\p{Space})([0-9]+\\p{Punct})(.+?)\\s*(?=Map|$)").matcher(s);
while(m.find())
{
System.out.println(m.group());
}