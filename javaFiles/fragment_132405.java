JDialog dialog = pane.createDialog(parentComponent, title);
dialog.show();
Object selectedValue = pane.getValue();
if(selectedValue == null)
  return CLOSED_OPTION;
//If there is not an array of option buttons:
if(options == null) {
  if(selectedValue instanceof Integer)
     return ((Integer)selectedValue).intValue();
  return CLOSED_OPTION;
}