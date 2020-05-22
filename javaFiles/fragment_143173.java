JFrame frame = new JFrame();
JLabel label = new JLabel();
DecimalFormat df = new DecimalFormat("#0.###");
label.setText(df.format(4e12));
frame.add(label);
frame.pack();
frame.setVisible(true);