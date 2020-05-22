for (int i = 0; i < size; i++) {
        for (int j = 1; j <= 100; j++) {
            D[i][j] = Integer.MAX_VALUE; // fill with MAX_VALUE because we want to minimize
            if (i == 0) {
                // for the first element we just set the cost of adjusting A[i] to j
                D[i][j] = Math.abs(j - A.get(i));
            }