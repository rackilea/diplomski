ActionListener al = new ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    // either do it like this
    process(e.getActionCommand());
    // or like this to distinguish between the controls
    if (e.getSource() == firstElement) processChangeInFirstElement();
    else if (e.getSource() == secondElement) processChangeInSecondElement();
    // etc
  }
}

Component firstElement = new JCheckBox("asdf");
firstElement.addActionListener(al);

Component secondElement = new JTextField();
secondElement.addActionListener(al);