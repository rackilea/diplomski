double[][] copy = new double[this.matrix.length][];
for (int i = 0; i < copy.length; ++i) {
  copy[i] = new double[this.matrix[i].length];
  for (int j = 0; j < copy[i].length; ++j) {
    copy[i][j] = this.matrix[i][j];
  }
}