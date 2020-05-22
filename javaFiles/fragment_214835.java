private final ChangeListener<Boolean> listener = (observable, oldValue, newValue) -> printMessage();

@FXML private void initialize() {
    ...
    mySingleton.booleanPropertyProperty().addListener(listener);
    ...
}

...

@FXML private void goBack() {
    // remove listener
    MySingleton.getInstance().booleanPropertyProperty().removeListener(listener);        
    ...
}