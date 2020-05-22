List<String> selectedItems = myJList.getSelectedValuesList();
for (int i = 0; i < selectedItems.size(); i++){
    String item = selectedItems.get(i);
    String update[] = item.split(", ");
    //this part removed for sake of post
    //....
}
myJList.removeAll();