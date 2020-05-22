public static void main(String[] ar)
{
List<String> all=new LinkedList<String>();
Set<String> result=new LinkedHashSet<String>();
all.add("interpreter");
all.add("interprete");
all.add("interpret");
all.add("developed");
all.add("develops");
String small="";

for(int i=0;i<all.size();i++)
{
    small=all.get(i);
    for(int j=i;j<all.size();j++)
    {
        if(small.contains(all.get(j)))
            {
                small=all.get(j);
            }
    }
    result.add(small);
}
for (String string : result) {
    System.out.println(string);
}
}