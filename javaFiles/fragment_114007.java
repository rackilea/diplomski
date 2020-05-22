//fill the grid
for (int row2 = 0; row2 < board2.length; row2++) {
    for (int col2 = 0; col2 < board2[row2].length; col2++) { // notice 'board2[row].length'
        board2[row2][col2] = rand.nextInt(10);
    }
}