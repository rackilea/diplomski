for(int y = 0; y < myHidingPlaces.length; y++) {
    for(int x = 0; x < myHidingPlaces[0].length; x++) {
        if (myHidingPlaces[y][x] == 0) {
            continue;
        }
        int i = myHidingPlaces.length - y - 1;
        i = 1 + 2*i;
        int j = 2 + 4*x;
        // translate int to char;
        char val = (char) (myHidingPlaces[y][x] + '0');
        board[i][j] = val;
    }
}