protected void updateItem(ListItem item, boolean empty) {
    super.updateItem(item, empty);
    if (empty) {
        setText(null);
    } else {
        // Display item's value property
        setText(item.getValue());
    }
}