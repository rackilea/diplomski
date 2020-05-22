@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.combobox) {
        JComboBox<String> combobox = this.combobox;

        newdata.clear();    // Clear your list or create a new one otherwise data will keep piling up.  
        newdata.add("Test1");
        newdata.add("Test2");

        TestTableModel model = (TestTableModel) table.getModel();

        // Since you need to replace the whole data create a new Object[][] each time
        Object[][] newModelData = new Object[newdata.size()][3];

        // Set whatever data to the new array
        int i = 0;
        for (String text : newdata) {
            newModelData[i][0] = Boolean.TRUE;
            newModelData[i][1] = text;
            newModelData[i][2] = text;
            i++;
        }

        // replace all data of the current model
        model.setData(newModelData);
    }
}
....

// Now inside your table model:
    ...
    @Override
    public Class<?> getColumnClass(int column) {
    // if (column == 0) {   
    //     return Boolean.class;             // <-- this produces a ClassCastException with the data you aretrying to set
    // }
       return super.getColumnClass(column);
    }

    public void setData(Object[][] data) {
        this.data = data;       //  <-- Update the data
        fireTableDataChanged(); //  <-- fire the event so the table is notified. If you change only one cell you need to call the appropriate fire event
    }
    ...