Pattern p = Pattern.compile("(?<==|^)\\w+");
String s = "someprefix foo=someval baz=anotherval baz=somethingelse";
Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println(m.group());
}