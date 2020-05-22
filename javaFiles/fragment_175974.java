JLabel label = new JLabel("<html> Instructions: Type in the grades you’ve received, along with the weights they’ll have in the determination of your overall average. <br> After you press ‘Calculate’, the results will show your average so far. <br> Every grade you enter must be a non-negative number, and every percentage/weight you enter must be a positive number :)</html>");

gbc.gridwidth = 2;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridy = 0;
panel.add(label, gbc);

//JLabel1 for Assingment/Grade/Weight(Percent)
JLabel label1 = new JLabel("<html><pre>Assingment\t\t\t\t\tWeight\t\t\t\t\tPercentage</pre></html>");
gbc.gridx = 0;
gbc.gridy = 1;
gbc.anchor = GridBagConstraints.NORTH;
gbc.weighty = 1;
panel.add(label1, gbc);