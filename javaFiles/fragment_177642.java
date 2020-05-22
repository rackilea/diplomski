int matrixSize = Math.sqrt(input.length());
for(int i = 0; i<matrixSize; i++) {
    for(int j = 0; j<matrixSize; j++){
        matrix[i][j] = input[j];
        j++;
    }
}