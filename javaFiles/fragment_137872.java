int[] indexOf(int [] [] ar, int row, int col, int x) { //this function will find x in 2D array ar(with dimension of row*col) and return the index
   int [] index = new int [2];
   index [0] = index[1] = -1; 
   for(int i = 0; i<row; i++) {
        for(int j = 0; j<col; j++) {
            if(ar[i][j] == x) {
               index[0] = i;
               index[1] = j;
               return index;
            }
        }
    }
    return index;
}