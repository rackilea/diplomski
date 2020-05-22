public static void main(String[] args) {
    String abc = "hello world ((((English)) {test}";
    Pattern pat = Pattern.compile("[()\\[\\]{}|]|\\s+");
    Matcher m = pat.matcher(abc);
    StringBuffer bufStr = new StringBuffer();
    while(m.find()) {
        m.appendReplacement(bufStr, m.group().contains(" ") ? "_" : "");
    }
    m.appendTail(bufStr);
    System.out.println(bufStr);
}