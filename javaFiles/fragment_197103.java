MainTree.setCellFactory((item) -> {
    return new CheckBoxTreeCell<String>(){

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if(item != null) {
                this.disableProperty().unbind();
                CheckBoxTreeItem<String> value = (CheckBoxTreeItem<String>) treeItemProperty().getValue();
                this.disableProperty().bind(value.leafProperty());
            }
        }
    };
});