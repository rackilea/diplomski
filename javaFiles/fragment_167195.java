JPanel controlPanel = new JPanel();
controlPanel.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.weightx = 1;
gbc.fill = GridBagConstraints.HORIZONTAL;
controlPanel.add(progressBar, gbc);