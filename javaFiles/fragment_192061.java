private void addItem(String item){
    // add some duplicate checking logic if needed

    // add the item to selected list
    selectedItems.add(item);

    // update the EditText
    updateEditText();
}