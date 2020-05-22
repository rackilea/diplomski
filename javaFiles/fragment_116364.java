subPanel.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.fill = GridBagConstraints.HORIZONTAL;
subPanel.add(upperPanel, gbc);
gbc.gridy = 1;
gbc.weighty = 1;
gbc.anchor = GridBagConstraints.SOUTH;
subPanel.add(lowerPanel, gbc);               // add each panel to the main subPanel
this.add(subPanel);