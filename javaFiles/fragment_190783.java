String test = "# Command\n\nFirst line of interest\r\nSecond line of interest\n\r\nThird line of interest\r\n\n";
System.out.printf("%n>>%s<<%n", test);

Pattern p = Pattern.compile("^(?!#).+(?:[\r\n]+.+)*", Pattern.MULTILINE);
Matcher m = p.matcher(test);
if (m.find())
{
  System.out.printf("%n>>%s<<%n", m.group());
}