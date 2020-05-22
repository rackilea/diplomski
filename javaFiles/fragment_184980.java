int outputRow = 0;
for(int row1 = 0; row1 < inputMatrix.length; row1++){
   for(int row2 = 0; row2 < inputMatrix.length; row2++){
        for(int col = 0; col < inputMatrix[0].length; col++){
            subtraction[outputRow][col] = inputMatrix[row1][col] - inputMatrix[row2][col];
        }
        outputRow++;
    }
}