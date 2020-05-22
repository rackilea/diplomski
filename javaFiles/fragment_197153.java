List<JComponent> jComponentList = new ArrayList<>();
    //add components
    for(int i=0;i<10;i++){
        JTextField textField = new JTextField();
        JComboBox comboBox = new JComboBox();
        textField.setName("textField" + i);
        comboBox.setName("comboBox" + i);
        jComponentList.add(textField);
        jComponentList.add(comboBox);
    }
    //iterate to get values
    for(JComponent component : jComponentList) {
        if(component instanceof JTextField) {
            System.out.println("textField Name is " + component.getName());
        }
        else if(component instanceof JComboBox) {
            System.out.println("jcomboBox Name is " + component.getName());
        }
    }