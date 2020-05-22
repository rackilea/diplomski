JFormattedTextField jftf2 = new JFormattedTextField();
final InternationalFormatter fmt=new InternationalFormatter(
  new MessageFormat("{0,number,000}-{1,number,0000}"));
jftf2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
  public JFormattedTextField.AbstractFormatter
                                         getFormatter(JFormattedTextField tf) {
    return fmt;
  }
});
jftf2.setValue(new Object[]{111,1234});