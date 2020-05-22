Map<Integer, Map<Integer, Cell>> grid = new HashMap<Integer, Map<Integer, Cell>>();

for (int x = 0; x <= COLS_NUM; x++) {
    Map inner = new HashMap<Integer, Cell>();
    for (int y = 0; y < ROWS_NUM; y++) {
        inner.put(y, new Cell());
    }
    grid.put(x, inner);
}