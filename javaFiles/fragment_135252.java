class MyTextFiledFocusListener extends FocusAdapter {
  private final JTextFiled textField;
  MyTextFiledFocusListener(JTextFiled textField){
    this.textField = textField;
    textField.addFocusListener(this);
  }
  public void focusGained(FocusEvent e) 
  {
    textField.setText("");
  }
}