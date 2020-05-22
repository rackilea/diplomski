String str = "item1 , it em 2,  ite m 3"
String[] splitArray = str.split(",");
ArrayList<String> list = new ArrayList<String>();
for (String s:splitArray)
{
    list.add(s.replace(" ", ""));
}