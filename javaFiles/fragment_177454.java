String i = "<Name_id = bob>";
Matcher m = Pattern.compile("<Name_id\\s+=\\s+([^>]+)>").matcher(i);
while(m.find())
{
    System.out.println(m.group(1));
}