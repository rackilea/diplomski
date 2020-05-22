private static class Cell {
    private final int row;
    private final int column;
    private final CELL_STATE state;

    public Cell(int row, int column, CELL_STATE state) {
        this.row = row;
        this.column = column;
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public CELL_STATE getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Cell{" +
            "row=" + row +
            ", column=" + column +
            ", state=" + state +
            '}';
    }
}