msgColumn.setCellFactory(tc -> {
        TableCell<LogMessage, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(msgColumn.widthProperty());
        text.textProperty().bind(cell.itemProperty());
        text.getStyleClass().add("table-cell-text");
        return cell ;
    });