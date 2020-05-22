final Pattern p = Pattern.compile("(?s)(?<=<).*?(?=/?>|\\s*\\w+\\s*=)");
Matcher m = p.matcher(data); // your XML
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, m.group().replace(" ", ""));
}
m.appendTail(sb);
data = sb.toString();
System.out.println(data);