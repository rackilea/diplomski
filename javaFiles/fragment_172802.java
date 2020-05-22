for (i = 0; i < row; i++) {
    for (j = 0; j < column; j++) {
        for (l = 0; l < row; l++) {
            sum += matrix[i][l] * matrix[l][j] ;
        }
        matrix[i][j] = sum ;
        sum = 0 ;
    }
}