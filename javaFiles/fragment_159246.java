private static void test(String s, int maxBytes, int expectedBytes) {
    String result = truncateWhenUTF8(s, maxBytes);
    byte[] utf8 = result.getBytes(Charset.forName("UTF-8"));
    if (utf8.length > maxBytes) {
        System.out.println("BAD: our truncation of " + s + " was too big");
    }
    if (utf8.length != expectedBytes) {
        System.out.println("BAD: expected " + expectedBytes + " got " + utf8.length);
    }
    System.out.println(s + " truncated to " + result);
}

public static void main(String[] args) {
    test("abcd", 0, 0);
    test("abcd", 1, 1);
    test("abcd", 2, 2);
    test("abcd", 3, 3);
    test("abcd", 4, 4);
    test("abcd", 5, 4);

    test("a\u0080b", 0, 0);
    test("a\u0080b", 1, 1);
    test("a\u0080b", 2, 1);
    test("a\u0080b", 3, 3);
    test("a\u0080b", 4, 4);
    test("a\u0080b", 5, 4);

    test("a\u0800b", 0, 0);
    test("a\u0800b", 1, 1);
    test("a\u0800b", 2, 1);
    test("a\u0800b", 3, 1);
    test("a\u0800b", 4, 4);
    test("a\u0800b", 5, 5);
    test("a\u0800b", 6, 5);

    // surrogate pairs
    test("\uD834\uDD1E", 0, 0);
    test("\uD834\uDD1E", 1, 0);
    test("\uD834\uDD1E", 2, 0);
    test("\uD834\uDD1E", 3, 0);
    test("\uD834\uDD1E", 4, 4);
    test("\uD834\uDD1E", 5, 4);

}