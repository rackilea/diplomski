jTextField2.setText("some text field content");
gridBagConstraints = new java.awt.GridBagConstraints();
gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;

gridBagConstraints.weightx = 1.0; //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

getContentPane().add(jTextField2, gridBagConstraints);