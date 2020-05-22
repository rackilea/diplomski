String s = "WHERE   table.it='2013-03-06-23'  OR  table.it='2013-03-07-00'  OR   table.it='2013-03-07-01'   OR   table.it='2013-03-07-02'   OR   table.it='2013-03-07-03'   OR   table.it='2013-03-07-04'   OR   table.it='2013-03-07-05'   OR   table.it='2013-03-07-06'  and table.name = 'test'";
Pattern p = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}-\\d{2})");
Matcher m = p.matcher(s);
m.find();
String first = m.group(1);
String last="";  
while(m.find()){
  last = m.group(1);
}
s = "WHERE table.it between "+first+" and "+last+" table.name = 'test'";