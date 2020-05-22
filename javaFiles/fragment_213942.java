Matcher m = Pattern.compile("\\{(.+?)\\}").matcher(myString);
List<String> list = new ArrayList<String>();
while (m.find())
{
    list.add(m.group(1));
}