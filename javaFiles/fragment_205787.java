public static void main(String[] args) throws Exception {
    String s1 = test1();
    String s2 = test1();
    System.out.println(s1 == s2); // true

    String s3 = test2();
    String s4 = test2();
    System.out.println(s3 == s4); // false
}

private static String test1() {
    final String foo = "string literal";
    return foo;
}

private static String test2() {
    final String foo = new String("string literal");
    return foo;
}