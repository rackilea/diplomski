int temp[][] = new int[matrix.length];

for (i = 0; i < matrix.length; i++) {
    temp[i] = new int[matrix[i].length];
    for (j = 0; j < matrix[i].length; j++) {
        sum = 0 ;
        for (l = 0; l < matrix.length; l++) {
            sum += matrix[i][l] * matrix[l][j] ;
        }
        temp[i][j] = sum ;
    }
}

// the result is now in 'temp', you could do this if you wanted:
matrix = temp;