textField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) { //when focus lost
            if(!textField.getText().matches("[1-5]\\.[0-9]|6\\.0")){
                //when it not matches the pattern (1.0 - 6.0)
                //set the textField empty
                textField.setText("");
            }
        }

    });