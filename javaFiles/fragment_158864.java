for (int row = 0; row <matrix.length; row++) {
    matrix[row][matrix[0].length-1] = false;
}
for (int col = 0; col <matrix[0].length; col++) { 
    matrix[row][matrix.length-1] = false;
}