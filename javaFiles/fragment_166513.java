String str = "5*10/2+cos(54/90)", regex = "(\\+|-)(?=(?:[a-zA-Z]*\\(.*?\\))|[0-9^*/]+$)";
Pattern pat = Pattern.compile(regex);
Matcher m = pat.matcher(str);
String r = "";
if(m.find())
{
    r = m.group(1).equals("+")?"-":"+";
}
str = str.replaceAll(regex, r);
System.out.println(str);