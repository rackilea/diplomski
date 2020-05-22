public static double maxZicZacSum(double[][] matrix) {
  double[] row = matrix[0]; // assign first row
  int n = row.length;
  for (int i = 1; i < matrix.length; i++) { // for each row, except the first
    double[] nextRow = new double[n];
    // special cases (left and right edge)
    nextRow[0] = row[1] <= 0 ? matrix[i][0] : row[1] + matrix[i][0];
    nextRow[n - 1] = row[n - 2] <= 0 ? matrix[i][n - 1] : row[n - 2] + matrix[i][n - 1];
    for (int j = 1; j < n - 1; j++) { // for each column except the edges
      double d = Math.max(row[j - 1], row[j + 1]); // which cell above is better?
      // if d is > 0, then the sum is also better, otherwise use (i,j) as new start
      nextRow[j] = d <= 0 ? matrix[i][j] : d + matrix[i][j];
    }
    row = nextRow; // finally assign nextRow to row for the next iteration
  }
  // the highest value in row is now the max sum
  double max = row[0];
  for (int i = 1; i < n; i++)
    if (row[i] > max)
      max = row[i];
  return max;
}