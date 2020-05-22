private ContextMenu showOnlyAppendContextMenuItemIfRowIsEmptyElseIncludeDelete() {

    ContextMenu rowMenu = new ContextMenu();
    ContextMenu tableMenu = table.getContextMenu();

    if (tableMenu != null) {
        for (MenuItem item : tableMenu.getItems()) {
            MenuItem rowItem = new MenuItem(item.getText());
            rowItem.setGraphic(item.getGraphic());
            rowItem.setOnAction(item.getOnAction());
            rowMenu.getItems().add(rowItem);
        }

    }

    rowMenu.getItems().add(new MenuItem("delete"));
    return rowMenu;
}