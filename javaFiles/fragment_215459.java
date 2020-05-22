public void LoadLineInJtable(){
    // get data and put into array or Vector
    String[] dataRow = { 
        jTjournal_submain_no.getText(), 
        jTjournal_submain_name.getText() 
    };

    // get table model and cast it to a DefaultTableModel
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // add row to model
    model.addRow(dataRow);
}