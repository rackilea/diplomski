addComponent(titleLabel, 0, 0, GridBagConstraints.REMAINDER, 2, inset); // I tried (0,1,2,2) 
addComponent(comboBox1, 3, 0, 1, 3, inset);
addComponent(comboBox2, 3, 2, 1, 3, inset);
addComponent(textField1, 6, 0, 1, 2, inset);
addComponent(equalLabel, 6, 1, 1, 2, inset);
addComponent(textField2, 6, 2, 1, 2, inset);
layoutConstraints.fill = GridBagConstraints.NONE;
addComponent(resultLabel, 8, 0, GridBagConstraints.REMAINDER, 1, inset);
addComponent(convertButton, 10, 0, GridBagConstraints.REMAINDER, 2, inset);