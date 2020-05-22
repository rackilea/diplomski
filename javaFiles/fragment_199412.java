public void test() {
    int n = 10098;
    while (n > 0) {
        System.out.println("n=" + n);
        n = n % (int) Math.pow(10, (int) Math.log10(n));
    }
}