JPanel panel1 = new JPanel();
panel1.add(listOfLabels.get(0));
panel1.add(listOfLabels.get(1));
panel1.add(listOfLabels.get(2));
panel1.add(listOfLabels.get(3));
ConnectionInfoPanel.add(panel1, c);


JPanel panel2 = new JPanel();
panel2.add(new JLabel("Label 5"));
panel2.add(new JLabel("Label 6"));
panel2.add(new JLabel("Label 7"));
panel2.add(new JLabel("Label 8"));

GridBagConstraints x = new GridBagConstraints();
x.weightx = 1;
x.weighty = 2;
x.insets = new Insets(10, 10, 10, 10);
// x.anchor = GridBagConstraints.NORTHWEST;

x.gridy = 0;
ConnectionInfoPanel.add(panel1, x);
x.gridy = 1;
ConnectionInfoPanel.add(panel2, x);