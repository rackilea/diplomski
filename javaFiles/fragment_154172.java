Pattern p = Pattern.compile("<InstanceIdentifier>\\b(.*?)\\b</InstanceIdentifier>");
Matcher m = p.matcher(s);
if(m.find())
{
System.out.println(m.group(1));
}