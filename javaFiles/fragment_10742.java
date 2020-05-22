Pattern p = Pattern.compile("\\w \\w");
Matcher m = p.matcher("a b c d e f ...");
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, "#");
}
m.appendTail(sb);
String result = sb.toString();