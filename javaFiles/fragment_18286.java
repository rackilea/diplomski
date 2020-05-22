JPanel myPanel = new JPanel();
myPanel.setBorder(new TitledBorder(null, "My Title", TitledBorder.LEADING, TitledBorder.TOP, null, null));

myPanel.setLayout(new GridLayout(1, 0, 0, 0));

JButton button = new JButton("New button");
myPanel.add(button);

JLabel label = new JLabel("New label");
myPanel.add(label);