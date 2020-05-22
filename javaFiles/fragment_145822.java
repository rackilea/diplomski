Matcher m = Pattern.compile("(?s)(?i)(?<=<code>)(.+?)(?=</code>)").matcher(string);
StringBuffer buf = new StringBuffer();
while (m.find()) {
    String grp = m.group(1).replaceAll("\\r?\\n", "<br />");
    grp = grp.replace("  ", " &emsp;");
    m.appendReplacement(buf, grp);
}
m.appendTail(buf);
// buf.toString() is your replaced string