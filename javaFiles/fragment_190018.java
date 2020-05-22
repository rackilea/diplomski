JPanel window = new JPanel();

JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new BorderLayout());
frame.add(window);
frame.setSize(200, 200);
frame.setLocationRelativeTo(null);
frame.setVisible(true);