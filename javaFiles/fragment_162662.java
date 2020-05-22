public static boolean isPrime(int p) {
    if(p <= 2) {
        return p == 2;
    }
    if(p % 2 == 0) {
        return false;
    }
    for (int i = 3; i*i <= p; i += 2) {
        if (p % i == 0) {
            return false;
        }
    }
    return true;
}