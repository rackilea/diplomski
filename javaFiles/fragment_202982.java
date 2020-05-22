int[][] matrix = new int[3][3];

for (int i = 0; i < matrix.length; i++) {
  for (int j = 0; j < matrix[i].length; j++) {
    matrix[i][j] = i * matrix[i].length + j;
  }
}