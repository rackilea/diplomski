//to create bottom panel with buttons
JPanel bottomPanel = new JPanel();

bottomPanel.setLayout(new FlowLayout());
bottomPanel.add(calculateButton = new JButton("Calculate"));
bottomPanel.add(saveButton = new JButton("Save"));
bottomPanel.add(clearButton = new JButton("Clear"));
bottomPanel.add(exitButton = new JButton("Exit"));