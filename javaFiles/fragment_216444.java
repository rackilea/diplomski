JComboBox comboBoxName = new JComboBox();
Controller ct = new Controller();
ArrayList<String> nameList = ct.fillComboBox();

for(String name : nameList){
    comboBoxName.addItem(name);        
}