// Provide our own ListCells for the ComboBox
    comboBox.setCellFactory(lv -> new ListCell<String>() {

        // We override the updateItem() method
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            // Set the style for this ListCell
            setStyle("-fx-alignment: center");

            // If there is no item for this cell, leave it empty, otherwise show the text
            if (item != null && !empty) {
                setText(item);
            } else {
                setText(null);
            }
        }
    });