String s = "blah blah\n{varName:param1, param2, param2}\nblah";

Pattern p = Pattern.compile(
  "\\{([a-zA-Z]+)(?:\\s*:\\s*([^,\\s]+(?:\\s*,\\s*[^,\\s]+)*))\\}"
);
Matcher m = p.matcher(s);
if (m.find())
{
  String varName = m.group(1);
  String[] params = m.start(2) != -1
                  ? m.group(2).split("[,\\s]+")
                  : new String[0];

  System.out.printf("var: %s%n", varName);
  for (String param : params)
  {
    System.out.printf("param: %s%n", param);
  }
}