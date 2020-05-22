jSpinner1 = new javax.swing.JSpinner();
 jSpinner1.setFont(new java.awt.Font("Calibri", 0, 14)); 
 jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));
 JFormattedTextField field1 = ((JSpinner.NumberEditor)        
 jSpinner1.getEditor()).getTextField();
 ((NumberFormatter) field1.getFormatter()).setAllowsInvalid(false);
 DefaultFormatter formatter1 = (DefaultFormatter) field1.getFormatter();
 formatter1.setCommitsOnValidEdit(true);