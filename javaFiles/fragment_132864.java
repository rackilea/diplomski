public static void main(String args[]) {
    int x = 1534236469;
    long ret = 0;
    while (x != 0) {
        ret = ret * 10 + x % 10;
        x /= 10;
    }
    System.out.println(ret);
}