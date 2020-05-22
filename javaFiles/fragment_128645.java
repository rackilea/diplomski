ActionListener numberButtonListener = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
     //  TODO: put some code here
  }
};

// assuming a List<AbstractButton> of the number buttons
for (AbstractButton numberButton : numberButtonList) {
  numberButton.addActionListener(numberButtonListener);
}