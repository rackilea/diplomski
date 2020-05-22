JFrame frame = new JFrame();

JPanel contentPanel = new JPanel();

contentPanel.setLayout(new BorderLayout());

JPanel buttonsPanel = new JPanel();
buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
buttonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

JButton b1 = new JButton("B1");
JButton b2 = new JButton("B2");

buttonsPanel.add(b1);
buttonsPanel.add(Box.createHorizontalStrut(5));
buttonsPanel.add(b2);

contentPanel.add(buttonsPanel, BorderLayout.NORTH);
contentPanel.add(new JTextArea(), BorderLayout.CENTER);

frame.setContentPane(contentPanel);
frame.setSize(400, 300);
frame.setVisible(true);