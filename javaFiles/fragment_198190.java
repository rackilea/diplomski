private List<JTextField> allTextFields = new ArrayList<JTextField>();

private JTextField createNewTextField(String text) {
    JTextField textField = new JTextField(text);
    allTextFields.add(textField);
    return textField;
}

private void resetAllTextFields(){
    for (JTextField textField : allTextFields) {
        textField.setText("");
    }
}