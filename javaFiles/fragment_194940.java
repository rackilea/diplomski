public static long productOfOddIntegers(int n){
    long prod = 1;
    for(int i = 3; i <= n; i += 2) {
        prod *= i;
    }
    return prod;
}