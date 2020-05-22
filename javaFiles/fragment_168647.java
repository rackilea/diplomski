myGrid.setCanSelectCells(true);

myGrid.addCellSelectionChangedHandler(new CellSelectionChangedHandler() {
  public void onCellSelectionChanged(CellSelectionChangedEvent event) {  
    CellSelection selection = countryGrid.getCellSelection();

    //use to determine if excluded column is clicked:
    int[][] selectedCells = selection.getSelectedCells();

    //use to get selected row: 
    ListGridRecord record = selection.getSelectedRecord();

    //etc...
  }
}