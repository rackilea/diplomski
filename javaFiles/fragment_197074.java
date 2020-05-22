Matcher m = Pattern.compile("(\\w+) = \"(\\d+)\"").matcher(s);
StringBuilder builder = new StringBuilder();
while (m.find()) {
   builder.append(m.group(1));
   builder.append("=");
   builder.append(m.group(2));
   builder.append(" ");
}