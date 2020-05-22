FMatrix newMatrix = new FMatrix(mat1);
for (int i = 0; i < getRows(); i++) {
  for (int j = 0; j < getColumns(); j++) {
    value = getElement(i, j) * scalar;
    mat1[i][j] = value;
  }
}

return newMatrix;