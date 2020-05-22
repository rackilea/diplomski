public static void main(String[] args) {
    test("Viuhaskfdksjfkds  XYBC4975723434 fkdsjkfjaksjfklsdakldjsen");
    test("XYBC4975723434");
    test("Viuhaskfdksjfkds  xXYBC4975723434 fkdsjkfjaksjfklsdakldjsen");
    test("abc XYBC49-75(723)4$34 xyz");
}
private static void test(String text) {
    Matcher m = Pattern.compile("\\bXYBC.*?\\b").matcher(text);
    if (m.find()) {
        System.out.println(m.group());
    } else {
        System.out.println("Not found: " + text);
    }
}