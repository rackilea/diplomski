JFrame gui = new JFrame("Button on bottom.");

JPanel panel = new JPanel(new BorderLayout());

JTextField textfield = new JTextField();
textfield.setText("Australia");

JTextArea textarea = new JTextArea();
textarea.setText("Australia, -27, 133. AUD");

JButton button = new JButton("Button on bottom.");
button.setFont(new java.awt.Font("Dialog", 0, 15));
button.setBorderPainted(false);
button.setFocusable(false);
button.setForeground(new java.awt.Color(255, 255, 255));
button.setBackground(new java.awt.Color(0, 140, 255));

panel.add(textfield, BorderLayout.PAGE_START);
panel.add(textarea);
panel.add(button, BorderLayout.PAGE_END);

gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);
gui.setSize(300, 300);
gui.setLocationRelativeTo(null);
gui.add(panel);
gui.setVisible(true);}}