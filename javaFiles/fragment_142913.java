else {
    for (int k = 1; k <= 100; k++) {
        // if abs(j-k) > target then changing A[i] to j isn't valid (when A[i-1] is k)
        if (Math.abs(j - k) > target) {
            continue;
        }
        // otherwise, calculate the the cost of changing A[i] to j and add to it the cost of changing A[i-1] to k
        int dif = Math.abs(j - A.get(i)) + D[i - 1][k];
        // minimize D[i][j]
        D[i][j] = Math.min(D[i][j], dif);
     }
}