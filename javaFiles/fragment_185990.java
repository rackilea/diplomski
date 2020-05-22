@Override
public void itemStateChanged(ItemEvent e) {
    if(e.getStateChange() == ItemEvent.SELECTED){
        voilPart.addRow(new Object[] {  "col1",  "col2",
                 "col3", "col4", "col5",
                new Boolean(false), new Boolean(false), "col8" });
    }
}