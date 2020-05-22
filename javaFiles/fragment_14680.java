ListView<String> listView = new ListView<>();
PseudoClass inactive = PseudoClass.getPseudoClass("inactive");
listView.setCellFactory(lv -> new ListCell<String>() {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? null : item);
        pseudoClassStateChanged(inactive, item != null && item.endsWith(" - not active"));
    }
});