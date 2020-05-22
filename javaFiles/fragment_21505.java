while (i < nL && j < nR) {
  if (A[i] <= B[j]) {
    C[k] = A[i];
    i = i + 1;
  } else {
    C[k] = B[j];
    j = j + 1;
  }
  k = k + 1;
}