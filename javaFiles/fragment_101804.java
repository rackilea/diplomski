setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 1;
gbc.insets = new Insets(0, 0, 0, 0);
add(labelPanel, gbc);

gbc.gridx = 1;
gbc.insets = new Insets(0, 2, 0, 2);
add(nosePane, gbc);
gbc.gridx = 2;
add(mainPanel, gbc);