gbc.gridx = 0;
gbc.gridy = 0;
add(run, gbc);

gbc.gridx = 1;
gbc.gridy = 0;
add(open, gbc);

gbc.gridx = 2;
gbc.gridy = 0;
add(exit, gbc);

localConsole = new JTextArea(5, 20);
JScrollPane scrollPane = new JScrollPane(localConsole);

gbc.fill = GridBagConstraints.CENTER;
gbc.gridx = 0;
gbc.gridy = 1;
gbc.gridwidth = 3; // try this with 1 and 2 to see the difference.
add(scrollPane, gbc);