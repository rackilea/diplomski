DefaultComboBoxModel<ItemCombo> comboModel = new DefaultComboBoxModel<>();
JComboBox<ItemCombo> itemsComboBox = new JComboBox<>(comboModel);  // *** fixed ***

// ......

comboModel.addItem(new ItemCombo(someProduct));