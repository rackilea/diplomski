class MineFinderModel {
    public static int MINE_SQUARE = 10;
    public static int EMPTY_SQUARE = 0;

    int num_of_cols;
    int num_of_rows;
    int[][] the_minefield;

    public MineFinderModel(int n_cols, int n_rows) {
        num_of_rows = n_rows;
        num_of_cols = n_cols;
        the_minefield = new int[num_of_cols][num_of_rows];
    }

    public boolean addMine(int thisCol, int thisRow) {
        if (thisCol >= num_of_cols || thisRow >= num_of_rows)
            return false;
        if (the_minefield[thisCol][thisRow] == MINE_SQUARE)
            return false;
        the_minefield[thisCol][thisRow] = MINE_SQUARE;
        return true;
    }

    public int getValue(int thisCol, int thisRow) {
        if (thisCol >= num_of_cols || thisRow >= num_of_rows)
            return 0;
        return the_minefield[thisCol][thisRow];
    }

    public void addMinesToCorners() {
        the_minefield[0][0] = MINE_SQUARE;
        the_minefield[0][num_of_rows - 1] = MINE_SQUARE;
        the_minefield[num_of_cols - 1][0] = MINE_SQUARE;
        the_minefield[num_of_cols - 1][num_of_rows - 1] = MINE_SQUARE;
    }
}