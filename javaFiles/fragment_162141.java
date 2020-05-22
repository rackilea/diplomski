String x = textfield_1.getText();
String y = textfield_2.getText();
try {
    Integer integerfield_1 = Integer.parseInt(textfield_1.getText());
    System.out.println("Please Enter The Position");
    //TODO Fill GUI Form.
} catch (NumberFormatException exp) {
    exp.printStackTrace();
    System.out.println("Incorrect Integer (Integer Only)");
}