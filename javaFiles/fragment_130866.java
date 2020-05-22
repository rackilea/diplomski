public static boolean isNonNegative(double[][] m){
    // iterate over first dimension
    for(int i = 0; i < m.length; i++){
        // iterate over second dimension
        for(int j = 0; j < m[i].length; j++){
            if(m[i][j] < 0){
                // found a negative element, return immediately
                // since this means the whole matrix cannot be
                // called non-negative
                return false;
            }
        }
    }
    // if we get here then no elements have been found to be negative
    // thus the matrix is non-negative.
    return true;
}