public void setCell(Map<Integer, Map<Integer, Cell>> grid, Cell newCell, int x, int y) {
    if (grid.containsKey(x)) {
        grid.get(x).put(y, newCell);
    } else {
        grid.put(x, (new HashMap<Integer, Cell>().put(y, newCell)));
    }
}