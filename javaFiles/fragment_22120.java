//we need to know what digits are we still allowed to use
//(not used in this row, not used in this column, not used in
//the same 3x3 "sub-box")
boolean digits[] = new boolean[11];

//so we run through the rows/coumns around the place (x,y)
//we want to fill in this iteration
for (int i = 0; i < 9; i++) {
    //take a used number from the row of x (matrix[x][i]) and mark it
    // as used
    digits[matrix[x][i]] = true;
    //take a used number from the column of y (matrix[i][y]) and mark it
    // as used
    digits[matrix[i][y]] = true;
}

//find the top-left corner of the sub-box for the position (x,y) we
//want to fill in
//example: x is 8 -> 3 * 8/3 -> 6, so we start from 6
int boxX = 3 * (x / 3), boxY = 3 * (y / 3);

//iterate through the sub-box horizontally and vertically
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
    //take a used number from the sub-box and mark it
    // as used
        digits[matrix[boxX + i][boxY + j]] = true;
    }
}