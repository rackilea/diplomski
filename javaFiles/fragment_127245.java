static final Pattern UNICODE = Pattern.compile("\\\\u([0-9a-fA-F]{4})");

static String decodeUnicodeEscape(String s) {
    Matcher m = UNICODE.matcher(s);
    StringBuffer sb = new StringBuffer();
    while (m.find())
        m.appendReplacement(sb,
            String.valueOf((char)Integer.parseInt(m.group(1), 16)));
    m.appendTail(sb);
    return sb.toString();
}