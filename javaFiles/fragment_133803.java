for (int d = 1; d < 3; d++) {
    long p = pow(36, d);
    for (long n = p; n < 2 * p; n++) {
        String pwd = Long.toString(n, 36).substring(1);
        System.out.println(n + " " + pwd);
    }
}