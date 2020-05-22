@FXML
public void handleOperator(ActionEvent event) {

    double newNumber = new Double(displayField.getText());
    switch (currentOperation) {
        case "+":
            currentNumber += newNumber;
            break;
        case "-":
            currentNumber -= newNumber;
            break;
        case "÷":
            currentNumber /= newNumber;
            break;
        case "×":
            currentNumber *= newNumber;
            break;
        case "xⁿ":
            currentNumber = Math.pow(currentNumber, newNumber);
            break;
        default:
            break;
    }       
    displayField.setText("" + currentNumber);
}

@FXML
public void handleOperation(ActionEvent event) {
    currentNumber = new Double(displayField.getText());
    displayField.setText("");
    currentOperation = ((Button) event.getSource()).getText();
    switch (currentoperation) {
        case "AC":
            displayField.setText("");
            break;
        case "n!":
            currentNumber = factorial(currentNumber);
            break;
        case "±":
            currentNumber *= -1;
            break;
        case "√":
            currentNumber = Math.sqrt(currentNumber);
            break;
        case "sin":
            currentNumber = Math.sin(currentNumber);
            break;
        case "cos":
            currentNumber = Math.cos(currentNumber);
            break;
        case "tan":
            currentNumber = Math.tan(currentNumber);
            break;
        case "x²":
            currentNumber = Math.pow(currentNumber, 2);
            break;
        case "10\uF006":
            currentNumber = Math.pow(10, currentNumber);
            break;
        case "log":
            currentNumber = Math.log10(currentNumber);
            break;
        default:
            break;
    }
    displayField.setText("" + currentNumber);
}