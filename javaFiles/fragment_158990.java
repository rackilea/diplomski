//to select tableview row
StudentData selectedrow = studenttable.getSelectionModel().getSelectedItem();

//prepare query with blank ID to be filled with the value of the selected row
PreparedStatement ps = conn.prepareStatement("DELETE FROM Studentlist WHERE ID = ?");

//from the selected row getID only
ps.setString(1, selectedrow.getID());

//execute delete operation e.g DELETE FROM Studentlist WHERE ID = 123
ps.execute();