int[][] matrixDouble = new int[row][col];
for (row = 0; row < matrix.length; row++) {
    for (col = 0; col < matrix[row].length; col++) {
        matrixDouble[row][col] = matrix[row][col]*2; //element -> *2 -> store in new matrix
        System.out.print(matrixDouble[row][col] + " ");
    }
    System.out.println(); 
}