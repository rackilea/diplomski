myPanel = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridy = 0;
gbc.fill = GridBagConstraints.BOTH;

// change setMaximumSize to setPreferredSize for all buttons
button1.setPreferredSize(new Dimension(122, 50)); // etc

// increase Y coordinate after adding a button
myPanel.add(button1, gbc);
++gbc.gridy;
myPanel.add(button2, gbc);
++gbc.gridy;
myPanel.add(button3,gbc);
++gbc.gridy;
myPanel.add(button4, gbc);
++gbc.gridy;

// And of course, remove the BoxLayout.