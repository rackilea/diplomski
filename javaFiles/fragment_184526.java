String[] KundLista = { "Normal", "Företag", "Student"};
JComboBox comboBox = new JComboBox(KundLista);
comboBox.setToolTipText("Välj vilken typ av Kund du är"); 
combobox.setRenderer(new MyComboBoxRenderer("Choose"));  
comboBox.setSelectedIndex(-1); // By default it selects first item, we don't want any selection  
comboBox.setBounds(171, 46, 97, 22);
frame.getContentPane().add(comboBox);