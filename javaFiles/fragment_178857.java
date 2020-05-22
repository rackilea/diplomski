private TreeItem<Info> createTreeItem(Info info) {
    TreeItem<Info> item = new TreeItem<>(info);
    info.onHoldProperty().addListener((obs, wasOnHold, isNowOnHold) -> {
        if (isNowOnHold) {
            item.getChildren().forEach(child -> child.getValue().setOnHold(true));
        }
    });
    return item ;
}