static int nand(int a, int b) {
    return ~(a & b);
}

static int xor(int a, int b) {
    return nand(nand(a, nand(a, b)), nand(b, nand(a, b)));
}