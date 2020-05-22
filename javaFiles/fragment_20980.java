final Map<String, String> vars = new HashMap<String, String>();
vars.put("var", "ipsum");
final String s = "lorem ${var} dolor sit amet consectetur adipiscing elit";
final Matcher m = Pattern.compile("\\$\\{(.*?)\\}").matcher(s);
final StringBuffer b = new StringBuffer(s.length());
while (m.find()) m.appendReplacement(b, vars.get(m.group(1)));
m.appendTail(b);
System.out.println(b);