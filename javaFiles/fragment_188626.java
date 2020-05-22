public static void main(String[] args) {
    int[][] test = {{3, 9, 3, 5}, {4, 19, 4, 9}, {2, 10, 5, 6}};
    int[] result = test[0];
    for (int row = 1; row < test.length; row++) {
        for (int column = 0; column < test[0].length; column++) {
            if (test[row][column] > result[column]) {
                result[column] = test[row][column];
            }
        }
    }
    for (int number : result) {
        System.out.print(number + " "); // 4 19 5 9 
    }
}