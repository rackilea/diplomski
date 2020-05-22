class MyTextFiledFocusListener implements FocusListener {
  private final JTextFiled textField;
  MyTextFiledFocusListener(JTextFiled textField){
    this.textField = textField;
    textField.addFocusListener(this);
  }
  public void focusGained(FocusEvent e) 
  {
    textField.setText("");
  }

  public void focusLost(FocusEvent e)
  {
    // nothing
  }
}