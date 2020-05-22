GridBagConstraints gbc = new GridBagConstraints();
gbc.fill = GridBagConstraints.BOTH;
gbc.gridx = 0;
gbc.gridy = 0;
gbc.gridwidth = 2;

gbc.ipadx = 40;
gbc.ipady = 40;

container.add(productsButton, gbc);

gbc.gridy = 1;
gbc.gridwidth = 1;
container.add(new JButton("Entrée"), gbc);

gbc.gridx = 1;
container.add(new JButton("Sortie"), gbc);