ItemClass oro = new ItemClass("gold","10%");
    ItemClass platino = new ItemClass("platinum","15%");
    JComboBox jc = new JComboBox();
    jc = membox;
    jc.addItem(oro);
    jc.addItem(platino);

membox.addItemListener(new ItemListener() {

@Override
public void itemStateChanged(ItemEvent e) {

    if(e.getStateChange() == ItemEvent.SELECTED) {
        Object obj=(Object) membox.getSelectedItem();
        ItemClass itemclass=(ItemClass)obj;
        String value = itemclass.getValue();
        jTextField6.setText(value);
    }
}

});