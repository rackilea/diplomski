String input = "{zjdb={fname=jbdjd, lname=ejdj, xnum=zjdb, email=ejdj}, 2jdb={fname=ij, lname=vji, xnum=2jdb, email=bbb}}";
Pattern p = Pattern.compile("[{ ]xnum=([^,}]+)[,}]");
Matcher m = p.matcher(input);
while (m.find()) {
  String xnum = m.group(1);
  System.out.println(xnum);
}