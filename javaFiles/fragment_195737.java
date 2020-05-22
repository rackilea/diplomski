class ArrayWorld implements World {
    private Cell cells[][] = ...

    @Override
    public Cell get(int x, int y) {
        return cells[x][y];
    }
    ...
}