Pattern p = Pattern.compile("\\d+|[+-/*]");
String inp = "2/3/64/96";
Matcher m = p.matcher(inp);
while (m.find()) {
    System.out.println(m.group());
}