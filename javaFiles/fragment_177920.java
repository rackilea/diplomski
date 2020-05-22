Pattern p = Pattern.compile("([^.]*)\\s*\\(");
Matcher m = p.match(str);
if (m.find()) {
    String methodName = m.group(1);
    //...
}