CheckBoxTreeItem<Object> item = new CheckBoxTreeItem<>(new Hyperlink("abc"));
CheckBoxTreeItem<Object> item2 = new CheckBoxTreeItem<>("Hello World");
CheckBoxTreeItem<Object> item3 = new CheckBoxTreeItem<>("42");
CheckBoxTreeItem<Object> item4 = new CheckBoxTreeItem<>(new Hyperlink("def"));
item.getChildren().setAll(item2, item3, item4);

TreeView<Object> treeView = new TreeView<>(item);
treeView.setCellFactory(tv -> new CheckBoxTreeCell<Object>() {

    private final HBox graphicWrapper = new HBox();

    {
        graphicWrapper.setAlignment(Pos.BASELINE_LEFT);
    }

    @Override
    public void updateItem(Object item, boolean empty) {
        graphicWrapper.getChildren().clear();
        super.updateItem(item, empty);

        if (!empty && (item instanceof Node)) {
            // replace graphic & text
            setText(null);
            graphicWrapper.getChildren().setAll(getGraphic(),  (Node) item);
            setGraphic(graphicWrapper);
        }
    }

});