public int triangle(int row) {
  if (row == 0) {
    return 0;
  } else {
    return row + triangle(row - 1);
  }
}