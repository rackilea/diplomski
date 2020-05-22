String s = "Hello my name is Joe";    
Matcher m = Pattern.compile("Hello my name is ([\\w]*)").matcher(s);
if(m.matches())
{
    System.out.println("Name entered: " + m.group(1));
}