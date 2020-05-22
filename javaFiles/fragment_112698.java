jcbo.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    int index = jcbo.getSelectedIndex();
    value = ageRanges[index];
  }
});