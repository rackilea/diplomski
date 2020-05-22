column.setCellFactory(tc-> {
    TableCell<Word, Integer> cell = new TableCell<>();
    Text text = new Text();
    cell.setGraphic(text);
    text.setTextAlignment(TextAlignment.CENTER);
    text.setStyle("-fx-fill: -fx-text-background-color;");
    text.setFontSmoothingType(FontSmoothingType.LCD);
    text.wrappingWidthProperty().bind(column.widthProperty().subtract(5));
    text.textProperty().bind(Bindings.createStringBinding(() -> {
        if (cell.isEmpty()) {
            return null ;
        } else {
            return cell.getItem().toString();
        }
    }, cell.emptyProperty(), cell.itemProperty()));
    return cell;  
});