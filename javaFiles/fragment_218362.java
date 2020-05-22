int count = 0;
for(int k = 0; k < 9; k++) {
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            extraboard[count++] = SquareBoard[i+3*k/3][j+k%3*3];
        }    
    }
    Arrays.sort(extraboard);
    for(int j = 0; j < 9; j++) {
        if(extraboard[j] == truelist[j])
            loop += 1;
    }
    extraboard = new int[9];
    count = 0;
}