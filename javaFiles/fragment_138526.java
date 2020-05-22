frame = new JFrame(nameA);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new BorderLayout());
frame.add(this, BorderLayout.CENTER);
frame.pack();
frame.setResizable(false);
frame.setLocationRelativeTo(null);
frame.setVisible(true);