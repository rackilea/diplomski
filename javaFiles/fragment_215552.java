private void initBoard(){
    boolean[][] array = new boolean[nrRows][nrColumns]; 
    for(int i = 0; i < nrRows; i++){
        for(int y = 0; y < nrColumns; y++){
            array[i][y] = false;
        }
    } board = array;
}