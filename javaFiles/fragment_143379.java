for(int i=0; i< c.rows; i++){
    for(int j=0; j< c.cols; j++){
        for(int k=0; k< rows; k++){
            c.matrix[i][j] = c.matrix[i][j] + matrix[i][k] * b.matrix[k][j]; 
        }
    }
}