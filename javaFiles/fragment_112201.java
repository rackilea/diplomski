JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setContentPane(backgroundPane);
frame.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.weightx = 1;
gbc.weighty = 1;
gbc.anchor = GridBagConstraints.SOUTHEAST;
gbc.insets = new Insets(30, 30, 30, 30);

ButtonPane buttonPane = new ButtonPane();
frame.add(buttonPane, gbc);

frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);