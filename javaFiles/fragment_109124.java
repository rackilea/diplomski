public static double[][] sortColumns(double[][] m) {
    for (int col = 0; col < m[0].length; col++) {
        // Have we swapped one on this pass?
        boolean swapped;
        do {
            swapped = false;
            for (int row = 0; row < m.length - 1; row++) {
                // Should these be swapped?
                if (m[row][col] > m[row + 1][col]) {
                    // Swap this one with the next.
                    double temp = m[row][col];
                    m[row][col] = m[row + 1][col];
                    m[row + 1][col] = temp;
                    // We swapped! Remember to run through again.
                    swapped = true;
                }
            }
        } while (swapped);
    }
    return m;

}