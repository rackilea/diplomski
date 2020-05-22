public class Arrays {
    static int[][] transpose(int[][] a) {
        // Only works if a is rectangular (every row in a has the same number of columns)
        int[][] good = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            // Use a[i].length, not a[k].length because k will be bigger than a.length at some point.
            for (int k = 0; k < a[i].length; k++) {
                // i = row in 'a', column in 'good'
                // k = column in 'a', row in 'good'
                good[k][i] = a[i][k];
            }
        }
        return good;
    }
}