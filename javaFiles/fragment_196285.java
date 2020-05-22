public static String rotateStringMatrixBy90(String matrix) {
    int numberOfRows = 3; // this I leave as an exercise
    int numberOfColumns = 8; // same with this one

    String newMatrix = "";

    int count = 0;
    String[] newMatrixColumns= matrix.split("\n");
    while (count < matrix.split("\n")[0].length()) {
        for (int i = newMatrixColumns.length - 1; i > -1; i--) {
            newMatrix = newMatrix + newMatrixColumns[i].charAt(count);
        }

        newMatrix = newMatrix + "\n";
        count++;
    }

    return newMatrix;
 }