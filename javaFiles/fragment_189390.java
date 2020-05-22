String s = "2.1+(sin 2)";
ArrayList<String> lst = new ArrayList<String>(); 
Matcher m = Pattern.compile("\\d+(?:\\.\\d+)?|[a-zA-Z]+|[^\\s\\w\\.]").matcher(s);
while(m.find())
{
    lst.add(m.group());
}
System.out.println(lst);