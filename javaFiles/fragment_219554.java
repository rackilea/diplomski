gbc.gridy = 2;

//JLabel Number for the number list of assignments at the side.
for(int i = 1; i<=7; i++){
    String kok = String.valueOf(i);
    JLabel number = new JLabel(kok);
    number.setHorizontalAlignment(JLabel.CENTER);
    addComponent(panel, number, 0, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
}
gbc.gridy = 2;

//JTextfield for Mark
for(int i=0; i<7; i++){
    JTextField mark = new JTextField(20);
    addComponent(panel, mark, 1, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER,GridBagConstraints.NONE);
}
gbc.gridy = 2;

//JTextfield for Weight
for(int i=0; i<7; i++){
    JTextField weight = new JTextField(20);
    weight.setHorizontalAlignment(JLabel.CENTER);
    addComponent(panel, weight, 2, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER,GridBagConstraints.NONE);
}