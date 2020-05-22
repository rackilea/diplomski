private static String findAvailableSeat(int i) {
    // TODO Auto-generated method stub
    for (int row=0; row<9; row++) {
        for (int col=0; col<8; col++) {
            if(table[row][col]==i) {
                //find the seat location, set location to 0 and then return indices to show in user result
                table[row][col] = 0;
                return row + "," + col;
            }
        }
    }
    return null;
}