public static void main(String[] args) {
    int input = 0x1f923;
    int x = input - 0x10000;

    int highTenBits = x >> 10;
    int lowTenBits = x & ((1 << 10) - 1);

    int high = highTenBits + 0xd800;
    int low = lowTenBits + 0xdc00;

    System.out.println(String.format("[%x][%x]", high, low));
}