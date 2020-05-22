TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();

// Item here is the table view type:
Item item = table.getItems().get(row);

TableColumn col = pos.getTableColumn();

// this gives the value in the selected cell:
String data = (String) col.getCellObservableValue(item).getValue();