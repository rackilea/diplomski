for (int i=0; i <= r/2; i++){
    for (int j=0; j <= c; j++){
        temp = matrix[i][j];
        matrix[i][j] = matrix[r-i][j];
        matrix[r-i][j] = temp;
    }
}