Pattern p = Pattern.compile(
    "(?:([^\\s\\[]+)\\[|\\G)([^\\s=]+)=\"([^\"]*)\"[,\\s]*");

String s = "org.myobject[key1=\"value1\", key2=\"value2\", key3=\"value3\"]";
Matcher m = p.matcher(s);
while (m.find())
{
  if (m.group(1) != null)
  {
    System.out.printf("class : %s%n", m.group(1));
  }
  System.out.printf("key : %s, value : %s%n", m.group(2), m.group(3));
}