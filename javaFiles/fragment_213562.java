Pattern p = Pattern.compile("<(\\w+)>.+</\\1>");
String input = "Testing <tag>some <b>idiot</b> text</tag>idiot text continue..";
Matcher m = p.matcher(input);

for (int i = 0; m.find(i); i = m.start() + 1)
    System.out.println(m.group());