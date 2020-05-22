JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
JLabel label = new JLabel(new ImageIcon(val));
frame.setContentPane(label);
frame.pack();
frame.setVisible(true);