final Label selected = new Label();
table.getSelectionModel().selectedItemProperty().addListener(
    (observable, oldValue, newValue) -> {
        if (newValue == null) {
            selected.setText("");
            return;
        }

        selected.setText("Selected Number: " + newValue.getId());
    }
);