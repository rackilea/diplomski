Pattern p = Pattern.compile("\\(([^\\(\\)]*)\\)");
Matcher m = p.matcher( "(something), (something2), (something3)" );

while(m.find())
{
  System.out.println(m.group( 1 ));
}