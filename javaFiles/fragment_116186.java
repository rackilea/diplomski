String s = "...";
Pattern OCTAL = Pattern.compile("\\\\(\\d\\d\\d)");
StringBuffer sb = new StringBuffer();
byte[] b1 = new byte[1];
Matcher m = OCTAL.matcher(s);
while (m.find()) {
    String replacement = m.group(): // default original
    try {
        b1[0] = (byte)Integer.parseInt(m.group(1), 8);
        replacement = new String(b1, "ISO-8859-15");
    } catch (NumberFormatException e) {
        //...
    }
    m.appendReplacement(sb, replacement);
}
m.appendTail(sb);
s = sb.toString();