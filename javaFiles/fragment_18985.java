selPane.setLayout(new GridBagLayout());
selPane.setBorder(blackLine);

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.WEST;
gbc.insets = new Insets(2, 2, 2, 2);
charSelCombo.setPrototypeDisplayValue("Hello");
selPane.add(charSelCombo, gbc);
gbc.gridy++;
selPane.add(pickLvl, gbc);
gbc.gridy++;
selPane.add(nextLvl, gbc);

gbc.gridx = 1;
gbc.gridy = 1;
gbc.weightx = 1;
selPane.add(pickLvlAns, gbc);
gbc.gridy++;
selPane.add(nextLvlAns, gbc);