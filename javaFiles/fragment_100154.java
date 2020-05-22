// Create a cell to render each value.
TextCell textCell = new TextCell();

// Create a CellList that uses the cell.
CellList<String> cellList = new CellList<String>(textCell);

// Set the total row count. This isn't strictly necessary, but it affects
// paging calculations, so its good habit to keep the row count up to date.
cellList.setRowCount(data.getListOfStrings().size(), true);

// Push the data into the widget.
cellList.setRowData(0, data.getListOfStrings());

// Add the cell list to its parent widget
parent.add(cellList);