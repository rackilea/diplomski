private static boolean isPrimeNumberNotOptimized(int i) {
    for(int j=2; j <= i/2; j++) {
        // if it is, then its not prime 
        if((i%j) == 0) {
            return false;
        }
    }
    return true; 
}