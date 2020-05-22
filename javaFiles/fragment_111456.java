GridBagLayout gridbag = new GridBagLayout();
this.setLayout(gridbag);
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.HORIZONTAL;

JLabel lblGuidelines = new JLabel("Please neter a telephone number and check if it's valid or not");
JTextField txtNumberInput = new JTextField(12);
JButton btnCheck = new JButton("Check");
JButton btnClear = new JButton("Clear");
JTextArea textArea = new JTextArea(20, 12);

c.gridx = 0;
c.gridy = 0;
c.gridwidth = 2;
c.insets = new Insets(8, 8, 8, 8);
c.weightx = 1;
this.add(lblGuidelines, c);

c.gridx = 0;
c.gridy = 1;
this.add(txtNumberInput, c);

c.gridx = 0;
c.gridy = 2;
c.gridwidth = 1;
c.weightx = 0.5;
this.add(btnCheck, c);

c.gridx = 1;
c.gridy = 2;
this.add(btnClear, c);

c.gridx = 0;
c.gridy = 3;
c.gridwidth = 2;
c.weightx = 1;
this.add(new JScrollPane(textArea), c);