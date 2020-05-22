private void removeItem(String item){

    // remove the item from selected list
    selectedItems.remove(item);

    // update the EditText
    updateEditText();
}