private int[][] rotateClockWise(int[][] matrix) {
 int size = matrix.length;
 int[][] ret = new int[size][size];

 for (int i = 0; i < size; ++i) 
  for (int j = 0; j < size; ++j) 
   ret[i][j] = matrix[size - j - 1][i]; //***

 return ret;
}