int k=0;
for (i=0; i<=9; i++) {
    for (j=0; j<=9; j++) {
        if (j<=i) {
            B[k++] = A[i][j];
        }
    }
}