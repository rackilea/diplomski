cboSelection.setPromptText("Select Subject");
    cboSelection.setButtonCell(new ListCell<String>() {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty) ;
            if (empty || item == null) {
                setText("Select Subject");
            } else {
                setText(item);
            }
        }
    });