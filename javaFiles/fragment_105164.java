FMatrix newMatrix = new FMatrix(matrix);
for (int i = 0; i < newRows; i++) {
  for (int j = 0; j < newColumns; j++) {
    value = getElement(i, j) + other.getElement(i, j);
    this.matrix[i][j] = value;
  }
}
return newMatrix;