private double getXForCell(String id) {
    double res = -1;
    graph.clearSelection();
    graph.selectAll();
    Object[] cells = graph.getSelectionCells();
    for (Object object : cells) {
        mxCell cell = (mxCell) object;
        if (id.equals(cell.getId())) {
            res = cell.getGeometry().getX();
        }
    }
    graph.clearSelection();
    return res;
}