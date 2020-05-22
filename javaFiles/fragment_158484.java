JFrame frame = new JFrame();
JPanel topPanel = new JPanel();
topPanel.setLayout(new FlowLayout());
topPanel.add(new JLabel("Label 1"));
topPanel.add(new JLabel("Label 2"));
frame.add(topPanel, BorderLayout.NORTH);
JPanel bigPanel = new JPanel();
frame.add(bigPanel, BorderLayout.CENTER);