protected void postprocessModelChange(TableModelEvent e) {
    if (forceRevalidate && filteredRowCountChanged) {
        resizeAndRepaint();
    }
    filteredRowCountChanged = false;
    forceRevalidate = false;
}