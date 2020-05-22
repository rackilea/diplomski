String name = NameTXT.getText(); 
String amount = CountTXT.getText();

// searching for product
boolean isNewItem = true;

for (int i = 0; i < matrix.size(); i++){
    String search = matrix.get(i).get(0);

    if (name.equals(search)){
        OutputTXT.setText("Item already exists");
        isNewItem = false;
        break;
    } 
}

// insert if new item 
if ( isNewItem ) {
    List<String> col = new ArrayList<String>();
    col.add(name);
    col.add(amount);
    matrix.add(col);
    OutputTXT.setText(amount +" "+ name +" added");
}