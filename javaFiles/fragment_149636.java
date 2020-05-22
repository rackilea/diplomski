button.setDisable(true);
textField.textProperty().addListener((obj, oldVal, newVal) -> {

    if (newVal.trim().isEmpty()) { // if blank textfield
         button.setDisable(true);
    } else {
         button.setDisable(false); 
     }
});