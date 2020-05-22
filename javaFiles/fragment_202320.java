JLabel lblWelcome = new JLabel("Welcome To The Login Screen", SwingConstants.CENTER);
JPanel northPanel = new JPanel(new BorderLayout());
northPanel.setBackground(Color.green);
northPanel.add(lblWelcome, BorderLayout.CENTER);

frame.add(northPanel, BorderLayout.PAGE_START);
frame.add(centerPanel, BorderLayout.CENTER);