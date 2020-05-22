// fill the initial values
for (int i = 0; i < size; ++i) {
    for (int j = 1; j <= 100; ++j) {
        // on the first element just save the cost of changing
        // A[i] to j
        if (i == 0) {
            DP[i][j] = abs(j-A.get(i));
        } else {
            // otherwise intialize with MAX_VALUE
            D[i][j] = Integer.MAX_VALUE;        
        }

    }
}
for (int i = 1; i < size; i++) {
    for (int j = 1; j <= 100; j++) {
        for (int k = 1; k <= 100; k++) {
            // if abs(j-k) isn't valid skip it
            if (Math.abs(j - k) > target) {
                continue;
            }
            // if it is valid, calculate the cost of changing A[i] to j
            // and add it to the cost of changing A[i-1] to k then minimize
            // over all values of j and k
            int dif = Math.abs(j - A.get(i)) + D[i - 1][k];
            D[i][j] = Math.min(D[i][j], dif);
        }
    }
}

// calculate the minimum cost at the end
int ret = Integer.MAX_VALUE;
for (int i = 1; i <= 100; i++) {
    ret = Math.min(ret, D[size - 1][i]);
}