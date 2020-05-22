public static boolean sameLengths(int[][] matrix) {
    if(matrix == null) {
        return false;
    }
    if(matrix.length > 0) {
        if(matrix[0] == null) {
            return false;
        }
        int n = matrix[0].length;
        for(int[] row : matrix) {
            if(row == null || row.length != n) {
                return false;
            }
        }
    }
    return true;
}