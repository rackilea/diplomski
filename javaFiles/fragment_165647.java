DialogModel model = new DialogModel(); 
...
@Override
protected void okPressed() {
model.setAttribute1(text1.getText());
model.setAttribute2(combo1.getText()); // or use getItem(selectedItemIndex); 
...
}