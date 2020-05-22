TableView table = new TableView(items);
table.getStyleClass().addAll("visible-lg", "visible-md");

ListView list = new ListView(items);
list.getStyleClass().addAll("visible-xs", "visible-sm");

pane.getChildren().addAll(table, list);