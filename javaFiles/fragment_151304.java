public void onPlusClick() {
    if (!isPlusToggled) {
        isPlusToggled = true;
        plusButton.setStyle("-fx-background-color: #85878c; -fx-border-color: #75767a;");
        input = Double.parseDouble(display.getText());
        display.setText("0");
        if (isFirstPlus) {
            result += input;
            isFirstPlus = false;
        }
    } else if (display.getText().equals("0")) {
        isPlusToggled = false;
        plusButton.setStyle("-fx-background-color: #2c2d2d; -fx-border-color: #2c2d2d");
      //this is the new else if statement.
    } else if (display.getText().equals(String.valueOf(result))) {
        display.setText("0");
    } else {
        input = Double.parseDouble(display.getText());
        result += input;
        display.setText(String.valueOf(result));
    }
}