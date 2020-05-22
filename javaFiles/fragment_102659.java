ImageIcon SettingsIc = new ImageIcon("settings.png");
jb1 = new JButton(SettingsIc);
jb1.setFocusPainted(false);
jb1.setContentAreaFilled(false);
jb1.addActionListener(new ActionListener() {

  @Override
  public void actionPerformed(ActionEvent arg0) {
     new SettingWindow();
  }
 });