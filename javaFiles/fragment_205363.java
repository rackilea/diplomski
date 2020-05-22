String result = "\"A\",\"B\",\"C\",\"D\",\"E\",\"F\"";
List list = new ArrayList();

list.add("One");
list.add("One2");
list.add("One3");

for(int i=0;i<list.size();i++)
{
   result += ",\"" + list.get(i) +"\""
}