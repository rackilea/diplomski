List<JComboBox> list = new ArrayList<JComboBox>();

JComboBox box = new JComboBox();
panel.add(box);
list.add(box); //store reference to the combobox in list

// Later, loop over the list
for(JComboBox b: list){
    b.setSelectedIndex(0);
}