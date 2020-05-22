private void concatHori(boolean left) {
    if( left ){
        concatHori( 0, 0, 1 );
    } else {
        concatHori( board.size()-1, board.get(0).size()-1, -1 );
    }
}

private void concatHori(int rowstart, int colstart, int inc ) {
    for (int i=0; i<board.size(); i++) {
        int index = colstart;
        for (int j=0; j<board.get(0).size(); j++) {
            int rowIndex = rowstart + inc*i;
            int colIndex = colstart + inc*j;
            int val = board.get(rowIndex).get(colIndex);
            if (val != 0) {
                board.get(rowIndex).set(index, val);
                if (colIndex != index) {
                    board.get(rowIndex).set(colIndex, 0);
                }
                index += inc;
            }
        }
    }
}