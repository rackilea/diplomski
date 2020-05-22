public static int rowsToUse(Tree t) {
    int childrenRows = t.children.length == 0 ? 0 : 1;
    for (Tree child : t.children)
        childrenRows = lcm(childrenRows, rowsToUse(child));
    return 1 + childrenRows;
}


public static List<Cell> getCells(Tree t, int row, int col, int rowsLeft) {

    // Add top-most cell corresponding to the root of the current tree.
    int rootRows = rowsLeft / rowsToUse(t);
    List<Cell> cells = new ArrayList<Cell>();
    cells.add(new Cell(t.val, row, col, rootRows, width(t)));

    // Generate cells for subtrees.
    for (Tree child : t.children) {
        cells.addAll(getCells(child, row+rootRows, col, rowsLeft-rootRows));
        col += width(child);
    }

    return cells;
}