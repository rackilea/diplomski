// get the start index in the list
int selectedIndex = dataProvider.getList().indexOf(myObj); 
// set the visible range
dataGrid.setVisibleRange(selectedIndex,dataGrid.getVisibleItemCount());
// select the row
selectionModel().setSelected(myObj, true);  // select the row