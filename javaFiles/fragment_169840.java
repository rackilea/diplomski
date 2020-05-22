public void requiredFunction(int[][] array, int row, int column) {
  for (int i = 0; i < array.length; ++i) {
      for (int j = 0; j < array[i].length; ++j) {
           if (i == column && j == row)
               continue;
           if (Math.abs(i - column) == Math.abs(j - row) ||
               i - column == 0 || j - row == 0)
               array[i][j]++;                                    
      }
  }
}