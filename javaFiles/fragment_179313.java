JFrame frame = new JFrame("GolfScoresGUI");
JPanel panel=new JPanel();
panel.setPreferredSize(new Dimension(600,400)); // Not mandatory. Without this, the frame will take the size of the JLabel + JTextField
frame.add(panel);

JLabel label = new JLabel("Did you score it? ");
JTextField textField = new JTextField(10);
panel.add(label);
panel.add(textField);

frame.setVisible(true);
frame.pack();