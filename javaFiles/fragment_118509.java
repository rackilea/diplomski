List<String> listItems = classDAO.findElement();

    DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel();

    for(String string : listItems)
    {
        comboModel.addElement(string);
    }

    comboModel.addElement("All items");

    JComboBox<String> comboBox = new JComboBox<>(comboModel);