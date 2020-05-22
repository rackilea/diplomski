DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"foo", "bar"});
JComboBox box = new JComboBox(model);

String toAdd = "baz";
//does it exist?
if(model.getIndexOf(toAdd) == -1 ) {
    model.addElement(toAdd);
}