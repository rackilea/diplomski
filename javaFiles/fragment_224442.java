private boolean isParsable = false;
public void validateTextFieldLong2 (TextField textField, PseudoClass errorClass){
        textField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            try {Long.parseLong(textField.getText().trim());
                isParsable = true;
            }
            catch (NumberFormatException e){
                System.out.println(e);
                isParsable = false;
            }

            if (!newValue) { //when focus lost
                if(textField.getText().trim().isEmpty() || !isParsable){
                    textField.pseudoClassStateChanged(errorClass, true);
                }
                else textField.pseudoClassStateChanged(errorClass, false);
            }
        });
    }