TreeView<String> tree = ... ;

tree.setOnKeyPressed(e -> {
    TreeItem<String> selected = tree.getSelectionModel().getSelectedItem();
    if (selected != null && e.getCode() == KeyCode.DELETE) {
        System.out.println("Delete pressed on "+selected.getValue());
        // delete file associated with selected.getValue()...
    }
});