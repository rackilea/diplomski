int firstEmptyRow = connectFourBoardComp.size(); // default case: the the row is full of tokens
for (int i = 0; i < connectFourBoardComp; i++) {
    if (connectFourBoardComp[i][column] == p0) {
        firstEmptyRow = i;
        break; // break out of the loop
    }
}