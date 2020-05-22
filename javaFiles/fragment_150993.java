case "GBP":
        if(!checkIfNokTextFieldIsEmpty() && checkIfOtherTextFieldIsEmpty()) {
            otherTextField.setText(calculateFromNok(txt, "GBP"));
            otherLabel.setText("GBP");
        }

        else if(checkIfNokTextFieldIsEmpty() && !checkIfOtherTextFieldIsEmpty()) {
            nokTextField.setText(calculateToNok(txt, "GBP"));
        }