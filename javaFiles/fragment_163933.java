setLayout(new GridBagLayout());
GridBagConstraints gc = new GridBagConstraints();
gc.fill = GridBagConstraints.BOTH;

//Set the margin between components top, left, bottom, right
//gc.insets=new Insets(5, 5, 5, 5);

tf = new JTextField("A testing Sentence", 20);
tf.setFont(new Font("Serif", Font.PLAIN, 14));

gc.gridx = 0; // 1st row
gc.gridy = 0; // 1st column
gc.weighty = 0.9; // 90%
add(tf, gc);

b1 = new JCheckBox("Bold");
b2 = new JCheckBox("Italic");
gc.gridy = 1; // 2nd column
gc.weighty = 0.05;// 5%
add(b1, gc);

gc.gridy = 2; // 3rd column
gc.weighty = 0.05;// 5%
add(b2, gc);