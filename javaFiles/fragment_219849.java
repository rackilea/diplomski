private static boolean isPrime(long n) {
    boolean result = false;

    if(n == 2 || n == 3) return true;

    for (long i = 2; i <= (long) Math.sqrt(n); i++) {
        if (n % i == 0) {
            result = false;
            break;
        } else
            result = true;
    }

    System.out.println(n + " " + result);
    return result;
}