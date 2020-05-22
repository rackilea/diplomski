public static void transpose(int[][] array, int arrayRows, int arrayColumns) {
    int[][] transposedArray = new int[arrayColumns][arrayRows]; //swap number of rows and columns
    System.out.println("Transposed:");
    for (int i = 0; i < transposedArray.length; i++) { //take the length of transposedArray, not array
        for (int j = 0; j < transposedArray[i].length; j++) { //take the length of transposedArray, not array
            transposedArray[i][j] = array[j][i];
            System.out.print(transposedArray[i][j] + " ");
        }
        System.out.println();
    }
}