static String match(String s) {
    ArrayList<String> matches = new ArrayList<>();
    Matcher matcher = Pattern.compile("D+U").matcher(s);
    int i = 0;
    while (matcher.find(i)) {
       matches.add(matcher.group());
       i = matcher.end();
    }   
    return Collections.max(matches, Comparator.comparing(c -> c.length()));
}