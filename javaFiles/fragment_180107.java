int inputTextColumnPos; // position of your column

...

@UiHandler("myButton")
public void myButton_onClick(ClickEvent event) {
  for (MyBean my : listOfBeans) {
    my.setValue("value");

    // get the cell you want to update
    TextInputCell cell = (TextInputCell) table.getColumn(inputTextColumnPos).getCell();
    // re-create the view data for the cell because the current one isn't updated
    TextInputCell.ViewData viewData = new TextInputCell.ViewData("value");
    // CRUSH the other one 
    cell.setViewData(my, viewData);
  }

  // because we're never too sure
  table.redraw();
}