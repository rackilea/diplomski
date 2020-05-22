DefaultTableModel model = (DefaultTableModel)your_table.getModel();

 ... 

  model.setRowCount(0); // add this line

  while(rs.next()) {

     int lesson = rs.getInt("lessons");
     String name= rs.getString("names");
     String number= rs.getString("numbers");

     ....
     model.addRow(new Object[]{lessons, names, numbers});
  }