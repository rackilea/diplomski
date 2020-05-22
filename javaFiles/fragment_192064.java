public static void main(String[] args) {
    test("87", 10);
    test("1211", 3);
    test("3112", 4);
}
private static void test(String num, int base) {
    System.out.printf("%2d: ", base);
    int p = findPalindrome(Integer.parseInt(num, base), base);
    System.out.printf("%-15s", Integer.toString(p, base));
    if (base != 10)
        System.out.printf("   = (%-11d)", p);
    System.out.printf("%n%n");
}