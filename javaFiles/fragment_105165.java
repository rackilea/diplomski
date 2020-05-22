public FMatrix(int[][] matrix) {
  if (matrix.length == 0) {
    rows = 0;
    columns = 0;
  } else {
    rows = matrix.length;
    columns = matrix[0].length;
  }
  this.matrix = new int[rows][0];
  for(int row = 0; row < rows; row++) {
      this.matrix[rows] = matrix[rows].clone();
  }
}