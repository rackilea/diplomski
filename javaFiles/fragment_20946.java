JTabbedPane outter = new JTabbedPane();
JTabbedPane inner = new JTabbedPane();
inner.addTab("Inner Tab", new JPanel());
outter.addTab("Outter Tab", inner);

JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(outter);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);