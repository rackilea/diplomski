public static void main(String[] args) throws Exception {
    String s = "http://www.google.com/search?q=Regular+Expressions";
    String regex = "(?:.*?/){2}.*?(/\\w+)(\\?|#).*"; // Don't capture anything upto the 3rd "/" then capture everything until you get a "?" or a "#" and then don't capture the rest. Replace everything with the captured value
    String str = s.replaceAll(regex, "$1");
    System.out.println(str);
    String s2 = "https://www.google.com/hello?test#";
    String str2 = s2.replaceAll(regex, "$1");
    System.out.println(str2);

}