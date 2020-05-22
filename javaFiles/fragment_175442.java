private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Button to Start
    Object[] columnData = new Object[jTable1.getRowCount()];  // One entry for each row
    Object[] rowData = new Object [jTable1.getRowCount()];
    for (int i = 0; i < jTable1.getRowCount(); i++) {  // Loop through the rows
        // Record the 5th column value (index 4)
        columnData[i] = jTable1.getValueAt(i, 4);  
     }
     System.out.println(Arrays.toString(columnData));