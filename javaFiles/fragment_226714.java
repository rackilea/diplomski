column.setCellFactory(tc-> {
    TableCell<Word, Integer> cell = new TableCell<>() {
        private Text text = new Text();
        {
            this.setGraphic(text);
            text.setTextAlignment(TextAlignment.CENTER);
            text.setStyle("-fx-fill: -fx-text-background-color;");
            text.setFontSmoothingType(FontSmoothingType.LCD);
            text.wrappingWidthProperty().bind(column.widthProperty().subtract(5));
        }

        @Override
        protected void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                text.setText(null);
            } else {
                text.setText(item.toString());
            }
        }
    };
    return cell;  
});