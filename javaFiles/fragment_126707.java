private static boolean isPrimeNumberOptimized(int i) {
    for(int j=2; j <= i/j; j++) {
        // if it is, then its not prime 
        if((i%j) == 0) {
            return false;
        }
    }
    return true; 
}