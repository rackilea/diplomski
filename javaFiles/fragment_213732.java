sidepanel.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
// One component per row...
gbc.gridwidth = GridBagConstraints.REMAINDER;
// Fill the available column space, this does not mean
// fill to fit the available parent container width though
gbc.fill = GridBagConstraints.HORIZONTAL;
sidepanel.add(newgame, gbc);
sidepanel.add(ticketView, gbc);
sidepanel.add(moveView, gbc);
sidepanel.add(turn, gbc);
sidepanel.add(round, gbc);