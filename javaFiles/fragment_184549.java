private void saveText(evt) {
    String textField1Val = jTextField1.getText();
    String textField2Val = jTextField2.getText();
    String textField3Val = jTextField3.getText();
    String textField4Val = jTextField4.getText();
    String textField5Val = jTextField5.getText();
    String textField6Val = jTextField6.getText();
    String textField7Val = jTextField7.getText();

    PrintWriter writer = new PrintWriter("textFieldOutput.txt", "UTF-8");
    writer.println("First text field:");
    writer.println(textField1Val);
    writer.println("Second text field:");
    writer.println(textField2Val);
    writer.println("Third text field:");
    writer.println(textField3Val);
    writer.println("Fourth text field:");
    writer.println(textField4Val);
    writer.println("Fifth text field:");
    writer.println(textField5Val);
    writer.println("Sixth text field:");
    writer.println(textField6Val);
    writer.println("Seventh text field:");
    writer.println(textField7Val);
    writer.close();
}