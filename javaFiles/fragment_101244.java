class CustomerActionListener implements ActionListener
{
  private JComboBox<String> comboBox;
  public CustomerActionListener(JComboBox<String> comboBox){
    this.comboBox = comboBox;
  }
  @Override
  public void actionPerformed(ActionEvent event)
  {
    // Just use the comboBox
    ComboBoxModel<String> model = comboBox.getModel();
    int index = comboBox.getSelectedIndex();
    String choosen = model.getElementAt(index);
    System.out.println("Hey you choose "+choosen);
  }
}