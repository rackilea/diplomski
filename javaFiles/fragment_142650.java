private static void test(short x) {
    float y = (float)(x & 0x7FFF) / (1 << 12);
    if ((x & 0x8000) != 0)
        y = -y;
    System.out.printf("%04x: %g%n", x, y);
}