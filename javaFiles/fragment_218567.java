static int maxSumPath(int[][] data) {
    final int length = data.length;
    final int[][][] sumArr = new int[3][length][length];
    for (int row = length - 1; row >= 0; row--) {
        for (int col = 0; col < length; col++) {
            int val = data[row][col];
            int val2 = data[row][col] * 2;
            if (row == length - 1 && col == 0) {
                sumArr[0][row][col] = val;
                sumArr[1][row][col] = val2;
            } else if (row == length - 1) {
                sumArr[0][row][col] = sumArr[0][row][col - 1] + val;
                sumArr[1][row][col] = Math.max(
                    sumArr[1][row][col - 1] + val
                ,   sumArr[0][row][col - 1] + val2
                );
                sumArr[2][row][col] = Math.max(
                    sumArr[1][row][col - 1] + val2
                ,   sumArr[2][row][col - 1] + val
                );
            } else if (col == 0) {
                sumArr[0][row][col] = sumArr[0][row + 1][col] + val;
                sumArr[1][row][col] = Math.max(
                    sumArr[0][row + 1][col] + val2
                ,   sumArr[1][row + 1][col] + val
                );
                sumArr[2][row][col] = Math.max(
                    sumArr[1][row + 1][col] + val2
                ,   sumArr[2][row + 1][col] + val
                );
            } else {
                sumArr[0][row][col] = Math.max(
                    sumArr[0][row][col - 1], sumArr[0][row + 1][col]
                ) + data[row][col];
                sumArr[1][row][col] = Math.max(
                    Math.max(sumArr[0][row][col - 1], sumArr[0][row + 1][col]) + val2
                ,   Math.max(sumArr[1][row][col - 1], sumArr[1][row + 1][col]) + val
                );
                sumArr[2][row][col] = Math.max(
                    Math.max(sumArr[1][row][col - 1], sumArr[1][row + 1][col])+val2
                ,   Math.max(sumArr[2][row][col - 1], sumArr[2][row + 1][col])+val
                );
            }
        }
    }
    return sumArr[2][0][length - 1];
}