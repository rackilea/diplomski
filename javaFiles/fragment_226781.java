public static int gcd (int n, int m) {
    if ((n % m) == 0)
        return m; // <-- first correction
    else
        return gcd(m, n % m);  // <-- second correction
}