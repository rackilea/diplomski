TitleSpecifyChoiceField.setEditable(false);
TitleSpecifyChoiceField.setText("Please specify title...");

TitleChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mrs", "Miss", "Ms", "Dr", "Other..." }));
TitleChoice.setToolTipText("");
TitleChoice.addItemListener(new ItemListener(){
  public void itemStateChanged(ItemEvent e) {
    if (TitleChoice.getSelectedItem().equals("Other...")){
      TitleSpecifyChoiceField.setEditable(true);
    }
  }
});