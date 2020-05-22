public static int potenz2(int x, int n) {
    if (n == 0) {
        return 1;
    } else {
        return x * potenz2(x, n - 1);
    }
}