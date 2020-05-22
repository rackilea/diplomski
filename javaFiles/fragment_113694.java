boolean isPrime(int i) {
    int s = (int)Math.sqrt(i);
    for (int j = 2; j <= s; j++) {
        if (i % j == 0) { return false; }
    }
    return true;
}