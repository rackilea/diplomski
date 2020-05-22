String str = "<h1>";
String rx = "<(h1|h2|h3|h4|ul|td|div|table)";
Pattern ptrn = Pattern.compile(rx, Pattern.CASE_INSENSITIVE);
Matcher m = ptrn.matcher(str);
while (m.find()) {
    System.out.println(m.group(0));
}