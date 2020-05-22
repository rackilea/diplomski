Pattern p = Pattern.compile("\\[([^\\]]*)\\]");
Matcher m = p.matcher(input);
StringBuffer bufStr = new StringBuffer();
boolean flag = false;
while ((flag = m.find())) {
    String toReplace = m.group(1);
    m.appendReplacement(bufStr, map(toReplace));
}
m.appendTail(bufStr);
String result = bufStr.toString();