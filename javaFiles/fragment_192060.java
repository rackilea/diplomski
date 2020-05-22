private void updateEditText() {
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < selectedItems.size(); i++ ) {
        text.append(item);
        if(i != selectedItems.size() -1) {
            text.append(" + ");
        }
    }
    editText.setText(text.toString());
}