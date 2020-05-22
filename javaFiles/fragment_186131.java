protected void onClick(ActionEvent event) {
    // getText() returns type String
    String text1 = textField.getText();
    String text2 = textField2.getText();
    // parse() returns type int or Integer
    int int1 = Integer.parseInt(text1);
    int int2 = Integer.parseInt(text2);
    // using Integer here so we can use toString() next
    Integer result = int1 + int2;
    // setText() takes input of type String
    label.setText(result.toString());
}