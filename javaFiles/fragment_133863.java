public static final Pattern regex = Pattern.compile("[/*]|\\b[-+]");

public static List<String> split(String s, Pattern pattern) {
    Matcher m = pattern.matcher(s);
    List<String> ret = new ArrayList<String>();
    int start = 0;
    while (m.find()) {
        ret.add(s.substring(start, m.start()));
        ret.add(m.group());
        start = m.end();
    }
    if (start >= s.length()) {
        ret.add(s.substring(start));
    }
    return ret;
}