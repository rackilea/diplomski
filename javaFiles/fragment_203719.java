private static List<String> getArray(Pattern tagMatcher, String str) {
    Matcher m = tagMatcher.matcher(str);
    List<String> l = new ArrayList<String>();
    while(m.find()) {
        String s = m.group(); //will give you "#computer"
        s = s.substring(1); // will give you just "computer"
        l.add(s);
    }
    return l;
}