int[] sumRows(int ArrayR[][]){

    int row = ArrayR.length;
    int[] sumR = new int[row];
    for (int i = 0; i < row; i++){

        int col = ArrayR[i].length; 
        sumR[i] = 0;  
        for (int j = 0; j < col; j++){
            sumR[i] += ArrayR[i][j];
        }
    }
    return sumR;
}