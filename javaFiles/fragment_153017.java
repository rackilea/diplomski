btnMoveLeft = new JButton("-");
btnMoveLeft.setFocusable(false);
btnMoveLeft.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent arg0) {
    txtAbc.setCaretPosition(txtAbc.getCaretPosition() - 1); // move the carot one position to the left
  }
});
// omitted jpanel stuff

btnmoveRight = new JButton("+");
btnmoveRight.setFocusable(false);
btnmoveRight.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    txtAbc.setCaretPosition(txtAbc.getCaretPosition() + 1); // move the carot one position to the right
  }
});
// omitted jpanel stuff