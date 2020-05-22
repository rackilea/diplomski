textCol.setCellFactory(tc -> {
    TableCell<Status, String> cell = new TableCell<>();
    Text text = new Text();
    cell.setGraphic(text);
    cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
    text.wrappingWidthProperty().bind(textCol.widthProperty());
    text.textProperty().bind(cell.itemProperty());
    return cell ;
});