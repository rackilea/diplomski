JPanel subPanel = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.weightx = 1;
gbc.weighty = 1;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.insets = new Insets(4, 4, 4, 4);

text = new JTextArea(1, 80);
text.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(4, 4, 4, 4)));
subPanel.add(text, gbc);

gbc.insets = new Insets(0, 0, 0, 0);
gbc.weightx = 0;
gbc.weighty = 0;
gbc.fill = GridBagConstraints.HORIZONTAL;
send = new JButton("Send");
subPanel.add(send, gbc);