static String toUnicode(String s) {
    Matcher m = Pattern.compile("u(\\p{XDigit}{4})").matcher(s);
    StringBuffer buf = new StringBuffer();
    while(m.find())
        m.appendReplacement(buf, "" + (char) Integer.parseInt(m.group(1), 16));
    m.appendTail(buf);
    return buf.toString();
}