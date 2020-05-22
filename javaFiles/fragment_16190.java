textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if(!newValue) {
            System.out.println("Focusing out from textfield");
        }
    }
});