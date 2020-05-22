boolean[] bannedRows = new boolean[n];
boolean[] bannedColumns = new boolean[n];
for (int i = 0; i < n; i++) {
  for (int j = 0; j < n; j++) {
    if (matrix[i][j]) {
      bannedRows[i] = true;
      bannedColumns[j] = true;
    }
  }
}
int count = 0;
for (int i = 0; i < n; i++) {
  for (int j = 0; j < n; j++) {
    if (!bannedRows[i] && !bannedColumns[j]) {
      count++;
    }
  }
}
return count;