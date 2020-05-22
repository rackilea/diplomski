String value = jTextField1.getText(); // Search Criteria.
if (value.isEmpty()) {
    return;  // Search criteria is empty. Get outta here.
}

DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

String id = ""
String name = ""
int r; 
for (r = 0; r < model.getRowCount(); r++){
    // Does the current column cell match the search criteria?
    if (value.equals(model.getValueAt(r, 0))) {
        // Yes it does...
        id = model.getValueAt(r, 0).toString();    // Fill id variable
        name = model.getValueAt(r, 1).toString();  // Fill name variable
        jTable1.setRowSelectionInterval(r, r);     // Select JTable Row
        break;  // Break out of loop. Don't need it anymore.
    } 
}

// Search Item Not Found.
if (id.equals("") { 
    JOptionPane.showMessageDialog(this, "Search Criteria (" + value + 
                                  ") Could No Be Found!", 
                                  "Item Not Found", JOptionPane.WARNING_MESSAGE);
    return;  // Get out of method.
}

// Search Item Was Found, Fill JTextFields...
jTextField2.setText(id);
jTextField3.setText(name);