JPanel jpane = new JPanel(new GridBagLayout()) {

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }

};
jpane.add(btn);

c.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weightx = 1;
gbc.weighty = 1;
gbc.anchor = GridBagConstraints.NORTHWEST;
c.add(jpane, gbc);