public static void main(String[] args) {
    test("SomeString");
    test("SomeString1");
    test("SomeString1Word");
}
private static void test(String text) {
    String regex = "(?<=\\p{Ll})(?=\\p{Lu})";
    System.out.printf("%s -> %s%n", text, Arrays.toString(text.split(regex)));
}