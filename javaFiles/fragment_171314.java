@Override
public void start(Stage primaryStage) {
    CheckBoxTreeItem<String> item = new CheckBoxTreeItem<>(null, new Hyperlink("abc"));
    CheckBoxTreeItem<String> item2 = new CheckBoxTreeItem<>("Hello World");
    CheckBoxTreeItem<String> item3 = new CheckBoxTreeItem<>("42");
    item.getChildren().setAll(item2, item3);

    TreeView<String> treeView = new TreeView<>(item);
    treeView.setCellFactory(CheckBoxTreeCell.forTreeView());

    Scene scene = new Scene(treeView);

    primaryStage.setScene(scene);
    primaryStage.show();
}