textCol.setCellFactory(new Callback<TableColumn<Status, String>, TableCell<String, String>>() {

        @Override
        public TableCell<Status, String> call(
                TableColumn<Status, String> param) {
            TableCell<Status, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(cell.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell ;
        }

    });