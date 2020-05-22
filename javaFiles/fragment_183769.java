private void selectRowInTableAndScroll(int aRowIndex)
{
    fTable.clearSelection();
    fTable.getSelectionModel().addSelectionInterval(aRowIndex, aRowIndex);

    Rectangle r = fTable.getCellRect(aRowIndex, 0, true);
    r.height = Math.min(fScrollPane.getHeight(), r.height);
    fTable.scrollRectToVisible(r);
}