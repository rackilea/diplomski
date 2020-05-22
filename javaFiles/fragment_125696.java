private TextField lastFocusedTextField ;

@Override
public void initialize(URL location, ResourceBundle resources) {
    lastFocusedTextField = unitText ;

    unitText.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
        if (isNowFocused) {
            lastFocusedTextField = unitText ;
        }
    });

    quantityText.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
        if (isNowFocused) {
            lastFocusedTextField = quantityText;
        }
    });



}