bool place(int i, int start) {
    if (i == 8) {
        if (allOccupied()) {
           print();
           return true;
        }
    } else {
        for (int j = start, j < 32; j++) {
            int row = j / 4;
            int col = 2 * (j % 4) + row % 2;

            // add bishop at (col, row)
            // save occupancy matrix
            // add threat by (col, row) to matrix

            if (place(i + 1, j + 1)) return true;

            // revert matrix to saved matrix
            // remove bishop from (col, row)
       }
    }

    return false;
}