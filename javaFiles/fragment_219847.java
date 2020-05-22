private static boolean isPrime(long n) {
    boolean result = false;

    for(long i=1; i<n/2; i++) {
        if(n%2 == 0) {
            result = false;
            break;
        }
        else result = true;
    }
    return result;

}