final Label selected = new Label();
table.getSelectionModel().selectedItemProperty().addListener(
    new ChangeListener<IdentifiedName>() {
        @Override
        public void changed(
            ObservableValue<? extends IdentifiedName> observable, 
            IdentifiedName oldValue, 
            IdentifiedName newValue
        ) {
            if (newValue == null) {
                selected.setText("");
                return;
            }

            selected.setText("Selected Number: " + newValue.getId());
        }
    }
);