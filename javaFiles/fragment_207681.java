private static long factorial(int n) {

    if (n == 1 || n == 0) {
        return 1;
    } else if (n < 0) {  // factorials are not defined below 0, they can be interpolated
        return null;     // though, see note below
    } else {
        return n * factorial(n - 1);
    }
}