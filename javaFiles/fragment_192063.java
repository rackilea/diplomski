private static int findPalindrome(int num, int base) {
    for (int n = num, rev; n > 0; n += rev) {
        if ((rev = reverse(n, base)) == n)
            return n;
        System.out.printf("%-6s + %-6s", Integer.toString(n, base), Integer.toString(rev, base));
        if (base != 10)
            System.out.printf("   = (%-4d + %-4d) ", n, rev);
        System.out.printf("%n  = ");
    }
    return 0;
}
private static int reverse(int num, int base) {
    int rev = 0;
    for (int n = num; n != 0; n /= base)
        rev = rev * base + n % base;
    return rev;
}