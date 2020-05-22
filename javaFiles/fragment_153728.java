JPanel southPanel = new JPanel();

subtractButton = new JButton("Subtract");
southPanel.add(subtractButton);
subtractButton.addActionListener(this);

divideButton = new JButton("Division");
southPanel.add(divideButton);
divideButton.addActionListener(this);

frame.add(southPanel , BorderLayout.SOUTH);