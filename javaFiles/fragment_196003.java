stage.showAndWait() ;
CreateDBController controller = fxmlLoader.getController();
Optional<String> db = controller.getDatabaseName();
db.ifPresent(dbName -> {
    // do whatever you need with dbName, e.g.
    databaseView.getRoot().getChildren().add(new TreeItem<>(dbName));
});