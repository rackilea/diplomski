lbl_ping = new JLabel();

frame.setFocusableWindowState(false);
frame.setBackground(new Color(0, 0, 0, 0));
frame.setAlwaysOnTop(true);
frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
frame.getContentPane().setLayout(new java.awt.BorderLayout());
lbl_ping.setFont(new Font("serif", Font.PLAIN, 48));
lbl_ping.setForeground(Color.WHITE);
lbl_ping.setText(ping);
frame.add(lbl_ping);

// pack() first then setVisible()
frame.pack();
frame.setVisible(true);