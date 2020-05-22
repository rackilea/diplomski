String s = "aaa\\u2022bbb\\u2014ccc";
    StringBuffer buf = new StringBuffer();
    Matcher m = Pattern.compile("\\\\u([0-9A-Fa-f]{4})").matcher(s);
    while (m.find()) {
        try {
            int cp = Integer.parseInt(m.group(1), 16);
            m.appendReplacement(buf, "");
            buf.appendCodePoint(cp);
        } catch (NumberFormatException e) {
        }
    }
    m.appendTail(buf);
    s = buf.toString();