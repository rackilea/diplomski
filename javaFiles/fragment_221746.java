Pattern p = Pattern.compile("\\[(.*)\\] (.*)");
Matcher m = p.matcher("[ADDRESS] Custom address n 1");
if (m.find()) {
    String type = m.group(1);
    String field = m.group(2);
}