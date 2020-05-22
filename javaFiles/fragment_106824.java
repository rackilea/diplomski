String s = "1+40.2+(2)";
Pattern p = Pattern.compile("[0-9\\.]+|[+\\-*/]|[()]");
Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println(m.group());
}