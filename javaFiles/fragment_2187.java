private Map<String, String> sharedStrings = new HashMap<>().

public void shareString(String s) {
    String t = sharedStrings.get(s);
    if (t == null) {
        t = s;
        sharedStrings.put(t, t);
    }
    return t;
}