JTextField textField = new JTextField(20);

GridBagConstraints gbc = new GridBagConstraints();
//gbc.ipadx = 100;
//gbc.weightx = 1.0f;

JPanel content = new JPanel( new GridBagLayout() );
content.add(textField, gbc);

frame.setContentPane( content );