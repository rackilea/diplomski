public static void main(String[] args) {
    test(0x6B); // example in answer
    test(0x53); // example in question (83)
    test(0x29);
    test(0x14);
    test(0x0A);
    test(0x05);
    test(0x02);
    test(0x01);
    test(0x00);
    test(0x80000000);
    test(0xFFFFFFFE);
}
private static void test(int a) {
    System.out.printf("%32s: %d%n", Integer.toBinaryString(a), leftmostZeroBit(a));
}