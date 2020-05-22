JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

buttonPanel.add(Box.createHorizontalGlue());

buttonPanel.add(new JButton("Play"));
buttonPanel.add(new JButton("Stop"));

buttonPanel.add(Box.createHorizontalGlue());

frame.add(buttonPanel, BorderLayout.SOUTH);