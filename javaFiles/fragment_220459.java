void validate(final int[][] nsudokuBoard) {
    final int width = nsudokuBoard[0].length;
    final int depth = nsudokuBoard.length;

    for (int i = 0; i < width; i++) {
        int j = i;
        int reference = nsudokuBoard[i][j];

        do {
            if (j < width) {
                int current = nsudokuBoard[i][j];

                if (current == reference) {
                // invalid entry found do something
                }
            }
            if (j < depth) {
                // note reversed indexes
                int current = nsudokuBoard[j][i];

                if (current == reference) {
                // invalid entry found do something
                }
            }
            ++j;
        } while ((j >= width) || (j >= depth));
    }
}