@Override
public void start(Stage primaryStage) {
    TableView tv = createTableView();

    Scene scene = new Scene(tv);

    // generate layout pass
    tv.applyCss();
    tv.layout();

    // assign tooltips to headers
    tv.lookupAll(".column-header").stream().forEach(n -> {
        TableColumnHeader header = (TableColumnHeader) n;
        Tooltip tooltip = new Tooltip("Tooltip: " + header.getTableColumn().getText());
        ((Control) header.lookup(".label")).setTooltip(tooltip);
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}