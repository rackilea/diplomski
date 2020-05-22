final JTextField field = new JTextField();
...
saveButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent event) {
      new Record(field.getText());
   }

});