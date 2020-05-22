public static void main(String[] args) {
    String s1 = "@test";
    String s2 = "test@test";
    String pattern = "\\b@\\w{2,}\\b";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(s1);
    m.find();
    System.out.println(m.group());
}