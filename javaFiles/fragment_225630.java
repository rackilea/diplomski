boolean[][] array = new boolean[rows][cols];
 boolean alternating = false;
 Random random = new Random();
 for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
      int k = random.nextInt(i * cols + j + 1);
      int swapRow = k / cols;
      int swapCol = k % cols;
      boolean tmp = array[swapRow][swapCol];
      array[swapRow][swapCol] = alternating;
      array[i][j] = tmp;
      alternating = !alternating;
    }
 }