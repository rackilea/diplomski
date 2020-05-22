public static double[][] sortColumnsProperly(double[][] m) {
    // Sort each colum.
    for (int col = 0; col < m[0].length; col++) {
        // Pull the column out.
        double[] thisCol = new double[m.length];
        for (int i = 0; i < m.length; i++) {
            thisCol[i] = m[i][col];
        }
        // Sort it.
        Arrays.sort(thisCol);
        // Push it back in.
        for (int i = 0; i < m.length; i++) {
            m[i][col] = thisCol[i];
        }
    }
    return m;

}