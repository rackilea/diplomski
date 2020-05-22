frame.setLayout(null);

JTextField textField = new JTextField(10);
textField.setSize( textField.getPreferredSize() );
textField.setLocation(100, 100);
frame.add(textField);

ComponentResizer cr = new ComponentResizer();
cr.registerComponent(textField);