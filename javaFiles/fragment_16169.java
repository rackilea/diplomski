for (int i = 0; i < size; i++){ //"size" is the size of the square matrix 
    for (int j = 0; j < size; j++){
        for (int k = j+1; k < size; k++){
           if (arr[i][j] > arr[i][k]){ //arr[][] is of datatype int
                  int temp  =  arr[i][j];
                  arr[i][j] =  arr[i][k];
                  arr[i][k] =  temp;
            }

         }
     }
}