public static void switchRows(int[][] anArray) {
    for (int i = 0; i < anArray.length/2; i++) {
        for (int j = 0; j < anArray[i].length; j++) {
            int tmp = anArray[i][j];
            anArray[i][j] = anArray[anArray.length - i -1][j];
            anArray[anArray.length - i -1][j] = tmp;
        }
    }
}

public static void switchColumns(char[][] anArray) {
    for (int i = 0; i < anArray.length; i++) {
        for (int j = 0; j < anArray[i].length/2; j++) {
            char tmp = anArray[i][j];
            anArray[i][j] = anArray[i][j + anArray[i].length - 1];
            anArray[i][j + anArray[i].length - 1] = tmp;
        }
    }
}