JTextField score1 = new JTextField(10);
  JTextField score2 = new JTextField(10);
  JTextField score3 = new JTextField(10);
  JTextField score4 = new JTextField(10);
  JTextField score5 = new JTextField(10);

  JPanel scorePanel = new JPanel();
  scorePanel.add(new JLabel("First Test Score:"));
  scorePanel.add(score1);
  scorePanel.add(Box.createHorizontalStrut(15)); // a spacer
  scorePanel.add(new JLabel("Second Test Score:"));
  scorePanel.add(score2);
  scorePanel.add(Box.createHorizontalStrut(15));
  scorePanel.add(new JLabel("Third Test Score:"));
  scorePanel.add(score3);
  scorePanel.add(Box.createHorizontalStrut(15));
  scorePanel.add(new JLabel("Fourth Test Score:"));
  scorePanel.add(score4);
  scorePanel.add(Box.createHorizontalStrut(15));
  scorePanel.add(new JLabel("Fifth Test Score:"));
  scorePanel.add(score5);

  int result = JOptionPane.showInputDialog(null, scorePanel, 
           "Please enter all 5 test scores.");

  double Score1 = Double.parseDouble(score1.getText());
  double Score2 = Double.parseDouble(score2.getText());
  ... etc.