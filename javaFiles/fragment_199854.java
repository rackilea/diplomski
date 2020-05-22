// Update the array of objects with
// the changes the user has just entered in a cell.
// Then notify all listeners (if any) what column
// and row has changed. Further processing may take place there.

rowData[row][col] = value;
fireTableDataChanged();