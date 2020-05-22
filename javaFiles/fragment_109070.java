public static void main(String[] args) {
    String foo = "someStringInPrefix<a....<imgtag/>...</a>";
    Pattern regex = Pattern.compile("<a[\\s\\S]*(<imgtag\\/>)+[\\s\\S]*</a>");
    Matcher regexMatcher = regex.matcher(foo);
    while(regexMatcher.find()){
        System.out.println(regexMatcher.group());
    }
}