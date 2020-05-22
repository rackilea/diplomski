b.addActionListener(new ActionListener() {

  @Override
  public void actionPerformed(ActionEvent e) {
    b.getModel().setRollover(false);//reset the rollover flag
    JOptionPane jOP = new JOptionPane("Dummy message");
    JDialog dialog = jOP.createDialog(p, null);
    dialog.setVisible(true);
  }
});